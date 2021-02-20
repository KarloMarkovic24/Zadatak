package hr.akd.selekcijski.zadatak.service;

import hr.akd.selekcijski.zadatak.entity.User;
import hr.akd.selekcijski.zadatak.repository.UserRepository;
import hr.akd.selekcijski.zadatak.util.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveFromCsv(MultipartFile file) {
        try {
            List<User> users = CsvUtil.csvToUsers(file.getInputStream());
            userRepository.saveAll(users);
            //todo dodat ispis u konzolu
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
