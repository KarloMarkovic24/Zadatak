package hr.akd.selekcijski.zadatak.controller;

import hr.akd.selekcijski.zadatak.entity.User;
import hr.akd.selekcijski.zadatak.service.UserService;
import hr.akd.selekcijski.zadatak.util.CsvUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) { this.userService = userService; }


    @PostMapping("/csv-to-user")
    public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file) {

        if(CsvUtil.isCsvFormat(file)) {
            userService.saveFromCsv(file);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
