package com.example.tripplanner.Repository;


import com.example.tripplanner.Model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan,Integer> {

    Plan findPlanById(Integer id);
}
