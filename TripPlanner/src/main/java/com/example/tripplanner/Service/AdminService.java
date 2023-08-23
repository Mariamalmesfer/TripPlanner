package com.example.tripplanner.Service;


import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;


    public List<Admin> getAllAdmin(){

        return adminRepository.findAll();
    }

    public void addAgent(Admin admin){

        adminRepository.save(admin);
    }

    public void updateAdmin(Integer id,Admin admin) {
        Admin OldAdmin= adminRepository.findAdminById(id);
        if (OldAdmin==null){
            throw new ApiException("id not found");
        }

        OldAdmin.setUsername(admin.getUsername());
        OldAdmin.setPassword(admin.getPassword());
        OldAdmin.setEmail(admin.getEmail());

        adminRepository.save(OldAdmin);


    }

    public void deleteAdmin(Integer id) {
        Admin OldAdmin= adminRepository.findAdminById(id);
        if (OldAdmin==null){
            throw new ApiException("id not found");
        }

        adminRepository.delete(OldAdmin);
    }




}
