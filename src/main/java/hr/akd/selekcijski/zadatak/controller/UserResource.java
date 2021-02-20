package hr.akd.selekcijski.zadatak.controller;

import hr.akd.selekcijski.zadatak.service.UserService;
import hr.akd.selekcijski.zadatak.util.CsvUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
