package com.example.tripplanner.Controller;


import com.example.tripplanner.ApiResponse.ApiResponse;
import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Model.Plan;
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





    @PutMapping("respoensticket/{ticket_id}/{msg}")
    public ResponseEntity RespoensTicket(@PathVariable String msg, @PathVariable Integer ticket_id ){
        adminService.RespoensTicket(ticket_id,msg);
        return ResponseEntity.status(200).body(new ApiResponse("Response Ticket added"));
    }

    @GetMapping("/getallticket/{admin_id}")
    public ResponseEntity getallticket(@PathVariable Integer admin_id){
        return ResponseEntity.status(200).body(adminService.getalladminticket(admin_id));
    }

    @GetMapping("/getallticketbyuser/{user_id}")
    public ResponseEntity getallticketbyuser(@PathVariable Integer user_id){
        return ResponseEntity.status(200).body(adminService.getalluserticket(user_id));

    }

    @PutMapping("/updateplan/{id}")
    public ResponseEntity updatePlanAfterChanges(@PathVariable Integer id, @RequestBody Plan updatePlan){
        adminService.updatePlanAfterChanges(id,updatePlan);
        return ResponseEntity.status(200).body(new ApiResponse("Plan updated")) ;
    }



    }
