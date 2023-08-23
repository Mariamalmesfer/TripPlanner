package com.example.tripplanner.Controller;

import com.example.tripplanner.ApiResponse.ApiResponse;
import com.example.tripplanner.Model.Package;
import com.example.tripplanner.Service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/package")
public class PackageController {

    private final PackageService packageService;

    @GetMapping("/get")
    public ResponseEntity getAllPackage(){
       return ResponseEntity.status(200).body(packageService.getAllPackages());
    }

    @PostMapping("/add")
    public ResponseEntity addPackage(@RequestBody Package newPackage){
        packageService.addPackage(newPackage);
        return ResponseEntity.status(200).body(new ApiResponse("Package added")) ;

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePackage(@PathVariable Integer id, @RequestBody Package updatePackage){
        packageService.updatePackage(id, updatePackage);
        return ResponseEntity.status(200).body(new ApiResponse("Package updated")) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePackage(@PathVariable Integer id){

        packageService.deletePackage(id);

        return ResponseEntity.status(200).body(new ApiResponse(" Package deleted")) ;
    }

    // Assign User to Package  (Many to Many)
    @PostMapping("/{user_id}/assign/{package_id}")
    private ResponseEntity assigncustomertomerchant(@PathVariable Integer user_id,@PathVariable Integer package_id){
        packageService.AssignUserToPackage(user_id,package_id);
        return ResponseEntity.status(200).body(new ApiResponse("User assign to package"));
    }
}
