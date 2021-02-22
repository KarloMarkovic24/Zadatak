package hr.akd.selekcijski.zadatak.controller;

import hr.akd.selekcijski.zadatak.exceptions.BadRequestException;
import hr.akd.selekcijski.zadatak.service.UserService;
import hr.akd.selekcijski.zadatak.util.CsvUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) { this.userService = userService; }


    @PostMapping("/csv-to-user")
    public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file) {

        if(!CsvUtil.isCsvFormat(file)) {
            throw new BadRequestException("Wrong file format !");
        }

        userService.saveFromCsv(file);
        return ResponseEntity.ok().build();
    }
}
