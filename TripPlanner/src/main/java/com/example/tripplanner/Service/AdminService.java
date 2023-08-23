package com.example.tripplanner.Service;


import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Model.Plan;
import com.example.tripplanner.Model.Ticket;
import com.example.tripplanner.Model.User;
import com.example.tripplanner.Repository.AdminRepository;
import com.example.tripplanner.Repository.PlanRepository;
import com.example.tripplanner.Repository.TicketRepository;
import com.example.tripplanner.Repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final PlanService planService;




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


    public void RespoensTicket(Integer ticket_id,String res){
        Ticket ticket = ticketRepository.findTicketById(ticket_id);
        if (ticket==null){
            throw new ApiException("id ticket not found");
        }

        ticket.setRespones(res);
        ticketRepository.save(ticket);

    }


    public List<Ticket> getalladminticket(Integer admin_id){
        Admin admin=adminRepository.findAdminById(admin_id);
        if (admin==null){
            throw new ApiException("admin id not found");
        }
        List<Ticket> tickets= ticketRepository.findTicketByAdmin(admin);

        return tickets;
    }


    public List<Ticket> getalluserticket(Integer user_id){
        User user=userRepository.findUserById(user_id);
        if (user==null){
            throw new ApiException("user id not found");
        }
        List<Ticket> tickets= ticketRepository.findTicketByUser(user);

        return tickets;
    }

   public void updatePlanAfterChanges(Integer id, Plan plan)
   {
       planService.updatePlan(id,plan);
   }





}
