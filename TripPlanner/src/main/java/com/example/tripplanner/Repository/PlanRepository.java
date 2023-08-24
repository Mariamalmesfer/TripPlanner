package com.example.tripplanner.Repository;


import com.example.tripplanner.Model.Plan;
import com.example.tripplanner.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan,Integer> {

    Plan findPlanById(Integer id);



    List<Plan> findPlanByStatusAndUser(String status , User user);
}
