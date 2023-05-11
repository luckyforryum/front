package ru.kata.spring.boot_security.demo.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.UserEntity;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }




    @GetMapping("/me")
    public Optional<UserEntity> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<UserEntity> user = userService.findByEmail(userDetails.getUsername());
        return user;
    }



//    @GetMapping("/")
//    public String showAllUsers(Principal principal,Model model) {
//        List<UserEntity> allUsers = userService.getAllUsers();
//        UserEntity userEntity = userService.getInfoByEmail(principal.getName());
//        model.addAttribute("email",principal.getName());
//        model.addAttribute("roles",userEntity.getRoles());
//        model.addAttribute("allRoles",roleService.getAllURoles());
//        model.addAttribute("allUsers",allUsers);
//        model.addAttribute("thisUser",userEntity);
//        return "all-users";
//    }


    @GetMapping("/getAllUsers")
    @ResponseBody
    public ResponseEntity<Iterable<UserEntity>> showAllUsers(Principal principal, Model model) {

        return ResponseEntity.ok().body(userService.getAllUsers());
    }




    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

//    @PostMapping("/addNewUser")
//    public String saveUser(@ModelAttribute UserEntity user) {
//        userService.save(user);
//        return "redirect:/admin/showAllUsers";
//    }

    @PostMapping("/addNewUser")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


//    @PostMapping("/admin/showAllUsers/update-info")
//    public String edit(@ModelAttribute UserEntity editUser) {
//        userService.update(editUser);
//        return "redirect:/admin/showAllUsers";
//    }




    @PutMapping("/editUser")
    public UserEntity edit(@RequestBody UserEntity editUser) {
        userService.update(editUser);
        return editUser;
    }



//    @PostMapping("/admin/showAllUsers/{userId}")
//    public String deleteUser(@PathVariable("userId") Long id) {
//        userService.delete(id);
//        return "redirect:/admin/showAllUsers";
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
