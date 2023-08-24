package com.example.tripplanner.Controller;

;
import com.example.tripplanner.ApiResponse.ApiResponse;
import com.example.tripplanner.Model.Ticket;
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

    @PutMapping("/addnewticket/{user_id}/{admin_id}/{plan_id}")
    public ResponseEntity addNewTicket(@PathVariable Integer user_id, @PathVariable Integer admin_id, @PathVariable Integer plan_id, @RequestBody @Valid Ticket ticket ){
        userService.addTicket(user_id,admin_id,plan_id,ticket);
        return ResponseEntity.status(200).body(new ApiResponse("Ticket added please wait for the response"));
    }

    @GetMapping("/checkrespoens/{user_id}")
    public ResponseEntity CheckRespoens(@PathVariable Integer user_id){
        return ResponseEntity.status(200).body(userService.CheckRespoens(user_id));
    }


    @GetMapping("/getallticket/{user_id}")
    public ResponseEntity getallticketbyid(@PathVariable Integer user_id){
        return ResponseEntity.status(200).body(userService.getallticketbyid(user_id));
    }



    @GetMapping ("/addplan/{package_id}/{user_id}")
    public ResponseEntity addplan(@PathVariable Integer package_id, @PathVariable Integer user_id){
        userService.addplan(package_id,user_id);
        return ResponseEntity.status(200).body(new ApiResponse("Package added please wait for the response"));
    }

    @PostMapping("/changstatus/{plan_id}")
    public ResponseEntity ChangStatusOfPlan( @PathVariable Integer plan_id ){
        userService.ChangStatusOfPlan(plan_id);
        return ResponseEntity.status(200).body(new ApiResponse("The status of plan is updated"));
    }




     @GetMapping("/getallapproveplan/{user_id}")
    public ResponseEntity getAllApprovePlan(@PathVariable Integer user_id){

        return ResponseEntity.status(200).body(userService.getAllApprovePlan(user_id));

    }
}
