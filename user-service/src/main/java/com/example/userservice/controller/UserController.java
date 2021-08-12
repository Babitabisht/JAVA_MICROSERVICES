package com.example.userservice.controller;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    User saveUser(@RequestBody User user){
        log.info("in user save user");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable("id") Long id){
        log.info("in  user get user by id");
                 return userService.getUser(id);
    }

    @GetMapping("/detail/{id}")
    ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id  ){
        log.info("In get user with department  ");
        return  userService.getUserWithDepartment(id);

    }

}
