package al.sda.demo.user.controller;


import al.sda.demo.participant.model.ParticipantDto;
import al.sda.demo.user.model.UserDto;
import al.sda.demo.user.service.UserService;
import al.sda.demo.util.RestUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    
    @GetMapping
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.getAllUsers(page, size));
    }


    @PostMapping
    public ResponseEntity<Void> saveUser(UserDto user) {
        Long id = userService.saveUser(user);
        URI location = RestUtil.locationBuilder(id.toString());

        return ResponseEntity.created(location)
                .build();
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable Long userId, @RequestBody UserDto updatedUser) {
        updatedUser.setId(userId);
        userService.updateUser(updatedUser);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent()
                       .build();
    }
}
