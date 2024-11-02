package ru.stepup.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.stepup.entity.User;
import org.springframework.stereotype.Service;
import ru.stepup.repo.UserRepo;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    //inject UserRepo
    private UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //add getUsers
    public List<User> getUsers() {
        List<User> list = userRepo.findAll();
        log.info(list.toString());
        return list;
    }
}
