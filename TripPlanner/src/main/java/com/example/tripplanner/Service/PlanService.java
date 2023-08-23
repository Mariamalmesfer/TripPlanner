package com.example.tripplanner.Service;


import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Model.Package;
import com.example.tripplanner.Model.Plan;
import com.example.tripplanner.Model.User;
import com.example.tripplanner.Repository.AdminRepository;
import com.example.tripplanner.Repository.PackageRepository;
import com.example.tripplanner.Repository.PlanRepository;
import com.example.tripplanner.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {


    private final PlanRepository planRepository;

    private final UserRepository userRepository;

    private final PackageRepository packageRepository;

    private final AdminRepository adminRepository;

    public List<Plan> getAllPlans(){
        return planRepository.findAll();
    }

    public void addPlan(Plan newPlan){
        planRepository.save(newPlan);

    }
    public void updatePlan(Integer id, Plan plan){
        Plan plan1 = planRepository.findPlanById(id);
        if(plan1 == null){
            throw new ApiException("not found");

        }
        plan1.setName(plan.getName());
        plan1.setDestination(plan.getDestination());
        plan1.setDuration(plan.getDuration());
        plan1.setCategory(plan.getCategory());
        plan1.setHotel(plan.getHotel());
        plan1.setFlightTicket(plan.getFlightTicket());
        plan1.setTotalPrice(plan.getTotalPrice());
        plan1.setStatus(plan.getStatus());
        planRepository.save(plan1);
    }

    public void deletePlan(Integer id){

        Plan plan = planRepository.findPlanById(id);
        if(plan == null){
            throw new ApiException("not found");

        }
        planRepository.delete(plan);

    }


   // Assign User To Plan (One to Many)
    public void assignUserToPlan(Integer user_id , Integer plan_id){
        User user = userRepository.findUserById(user_id);
        Plan plan = planRepository.findPlanById(plan_id);

        if(user == null || plan == null ){ throw new ApiException("can not assign id not found");}

        plan.setUser(user);

        planRepository.save(plan);

    }


    // Assign Package To Plan (One to Many)
    public void assignPackageToPlan(Integer package_id , Integer plan_id){
        Package aPackage = packageRepository.findPackageById(package_id);
        Plan plan = planRepository.findPlanById(plan_id);

        if(aPackage == null || plan == null ){ throw new ApiException("can not assign id not found");}

        plan.setAPackage(aPackage);

        planRepository.save(plan);

    }



    // Assign Admin To Plan (One to Many)
    public void assignAdminToPlan(Integer admin_id , Integer plan_id){
        Admin admin= adminRepository.findAdminById(admin_id);
        Plan plan = planRepository.findPlanById(plan_id);

        if(admin == null || plan == null ){ throw new ApiException("can not assign id not found");}

        plan.setAdmin(admin);

        planRepository.save(plan);

    }













}
