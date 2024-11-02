package ru.stepup.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.stepup.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stepup.service.UserService;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    //inject UserService
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> list = userService.getUsers();
        log.info(list.toString());
        return ResponseEntity.ok(list);
    }

    //add ExceptionHandler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
