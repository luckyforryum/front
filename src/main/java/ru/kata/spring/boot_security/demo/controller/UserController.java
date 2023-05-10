package ru.kata.spring.boot_security.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.UserEntity;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;



@RestController
@RequestMapping("/api")

public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/user")
//    public String pageForUser(Principal principal, Model model) {
//        UserEntity userEntity1 =  userService.getInfoByEmail(principal.getName());
//        String email = principal.getName();
//
//        model.addAttribute("thisUser",userEntity1);
//        model.addAttribute("email",email);
//        model.addAttribute("roles",userEntity1.getRoles());
//        return "user";
//    }

    @GetMapping("/user")
    public UserEntity pageForUser(Principal principal, Model model) {
        UserEntity userEntity1 =  userService.getInfoByEmail(principal.getName());
        String email = principal.getName();

        model.addAttribute("thisUser",userEntity1);
        model.addAttribute("email",email);
        model.addAttribute("roles",userEntity1.getRoles());
        return userEntity1;
    }

}
