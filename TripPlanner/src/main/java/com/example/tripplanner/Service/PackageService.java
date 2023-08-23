package com.example.tripplanner.Service;

import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.Package;
import com.example.tripplanner.Model.User;
import com.example.tripplanner.Repository.PackageRepository;
import com.example.tripplanner.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageService {

    private final PackageRepository packageRepository;
    private final UserRepository userRepository;

    public List<Package> getAllPackages(){

        return packageRepository.findAll();
    }

    public void addPackage(Package newPackage){
        packageRepository.save(newPackage);

    }
    public void updatePackage(Integer id, Package updatePackage){
        Package package1 = packageRepository.findPackageById(id);
        if(package1 == null){
            throw new ApiException("not found");

        }
        package1.setName(updatePackage.getName());
        package1.setDestination(updatePackage.getDestination());
        package1.setDuration(updatePackage.getDuration());
        package1.setCategory(updatePackage.getCategory());
        package1.setHotel(updatePackage.getHotel());
        package1.setFlightTicket(updatePackage.getFlightTicket());
        package1.setTotalPrice(updatePackage.getTotalPrice());
        packageRepository.save(package1);
    }

    public void deletePackage(Integer id){

        Package package1 = packageRepository.findPackageById(id);
        if(package1 == null){
            throw new ApiException("not found");

        }
        packageRepository.delete(package1);

    }


    // Assign User to Package  (Many to Many)
    public void AssignUserToPackage(Integer pakage_id,Integer user_id){
        Package package2= packageRepository.findPackageById(pakage_id);
        User user=userRepository.findUserById(user_id);

        if(package2==null || user==null){
            throw new ApiException("id not found");
        }
        package2.getUsers().add(user);
        user.getPackageSet().add(package2);
        packageRepository.save(package2);
        userRepository.save(user);

    }















}
