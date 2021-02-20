package hr.akd.selekcijski.zadatak.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    void saveFromCsv(MultipartFile file);
}
