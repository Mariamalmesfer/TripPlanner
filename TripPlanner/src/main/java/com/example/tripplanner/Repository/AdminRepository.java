package com.example.tripplanner.Repository;


import com.example.tripplanner.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

   Admin findAdminById(Integer id);
}
