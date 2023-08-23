package com.example.tripplanner.Controller;


import com.example.tripplanner.ApiResponse.ApiResponse;
import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/get")
    public ResponseEntity getAllAdmins() {

        return ResponseEntity.status(200).body(adminService.getAllAdmin());
    }

    @PostMapping("/add")
    public ResponseEntity addAdmins(@RequestBody @Valid Admin admin) {
        adminService.addAgent(admin);
        return ResponseEntity.status(200).body(new ApiResponse("Admin added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAdmins(@PathVariable Integer id, @RequestBody @Valid  Admin admin ){
        adminService.updateAdmin(id,admin );
        return ResponseEntity.status(200).body(new ApiResponse("Admin updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletAdmins(@PathVariable Integer id){
        adminService.deleteAdmin(id);
        return ResponseEntity.status(200).body(new ApiResponse("Admin deleted"));
    }


}
