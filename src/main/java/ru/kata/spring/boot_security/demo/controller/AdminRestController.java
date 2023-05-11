package ru.kata.spring.boot_security.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.UserEntity;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.util.Optional;


@RestController
@RequestMapping("/api/admin/")
@CrossOrigin(origins = "*")
public class AdminRestController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/me")
    public ResponseEntity<Optional<UserEntity>> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<UserEntity> user = userService.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok().body(user);
    }


    @GetMapping("/getAllUsers")
    @ResponseBody
    public ResponseEntity<Iterable<UserEntity>> showAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/editUser")
    public UserEntity edit(@RequestBody UserEntity editUser) {
        userService.update(editUser);
        return editUser;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
