package com.example.tripplanner.Controller;

;
import com.example.tripplanner.ApiResponse.ApiResponse;
import com.example.tripplanner.Model.User;
import com.example.tripplanner.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUser() {

        return ResponseEntity.status(200).body(userService.getAllUser());
    }


    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user) {
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id, @RequestBody @Valid  User user ){
        userService.updateUser(id,user );
        return ResponseEntity.status(200).body(new ApiResponse("User updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }



}
