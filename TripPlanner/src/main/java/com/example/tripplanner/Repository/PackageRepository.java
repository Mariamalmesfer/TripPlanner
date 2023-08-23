package com.example.tripplanner.Repository;


import com.example.tripplanner.Model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package,Integer> {

    Package findPackageById(Integer id);
}
