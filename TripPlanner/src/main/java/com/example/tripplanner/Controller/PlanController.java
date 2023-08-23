package com.example.tripplanner.Controller;

import com.example.tripplanner.ApiResponse.ApiResponse;
import com.example.tripplanner.Model.Plan;
import com.example.tripplanner.Service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/plan")
public class PlanController {

    private final PlanService planService;

    @GetMapping("/get")
    public ResponseEntity getAllPlans(){
        return ResponseEntity.status(200).body(planService.getAllPlans());
    }

    @PostMapping("/add")
    public ResponseEntity addPlan(@RequestBody Plan newPlan){
        planService.addPlan(newPlan);
        return ResponseEntity.status(200).body(new ApiResponse("added")) ;

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePackage(@PathVariable Integer id, @RequestBody Plan updatePlan){
        planService.updatePlan(id, updatePlan);
        return ResponseEntity.status(200).body(new ApiResponse("updated")) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlan(@PathVariable Integer id){

        planService.deletePlan(id);

        return ResponseEntity.status(200).body(new ApiResponse("deleted")) ;
    }

    // Assign User To Plan (One to Many)
    @PostMapping("/{user_id}/assignuser/{plan_id}")
    public ResponseEntity assignUserToPlan(@PathVariable Integer user_id , @PathVariable Integer plan_id){
        planService.assignUserToPlan(user_id,plan_id);
        return ResponseEntity.status(200).body("User assign to plan.");
    }

    // Assign Package To Plan (One to Many)
    @PostMapping("/{package_id}/assignpackage/{plan_id}")
    public ResponseEntity assignPackageToPlan(@PathVariable Integer package_id , @PathVariable Integer plan_id){
        planService.assignPackageToPlan(package_id,plan_id);
        return ResponseEntity.status(200).body("Package assign to plan.");
    }

    // Assign Admin To Plan (One to Many)

    @PostMapping("/{admin_id}/assignadmin/{plan_id}")
    public ResponseEntity assignAdminToPlan(@PathVariable Integer admin_id , @PathVariable Integer plan_id){
        planService.assignAdminToPlan(admin_id,plan_id);
        return ResponseEntity.status(200).body("Admin assign to plan.");
    }



}
