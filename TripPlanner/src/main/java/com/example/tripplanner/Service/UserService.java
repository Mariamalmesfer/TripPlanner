package com.example.tripplanner.Service;

import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Model.Package;
import com.example.tripplanner.Model.Plan;
import com.example.tripplanner.Model.Ticket;
import com.example.tripplanner.Model.User;
import com.example.tripplanner.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository ;
    private final AdminRepository adminRepository;
    private final TicketRepository ticketRepository;
    private final TicketService ticketService;
    private final PlanRepository planRepository;
    private final PlanService planService;
    private final PackageRepository packageRepository;


    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    public void addUser(User user){

        userRepository.save(user);
    }

    public void updateUser(Integer id,User user) {
        User OldUser= userRepository.findUserById(id);
        if (OldUser==null){
            throw new ApiException("id not found");
        }

        OldUser.setUsername(user.getUsername());
        OldUser.setPassword(user.getPassword());
        OldUser.setEmail(user.getEmail());


        userRepository.save(OldUser);

    }

    public void deleteUser(Integer id) {
        User OldUser= userRepository.findUserById(id);
        if (OldUser==null){
            throw new ApiException("id not found");
        }
        userRepository.delete(OldUser);
    }



    public void addTicket(Integer user_id , Integer admin_id,Integer plan_id, Ticket ticket){
        User OldUser= userRepository.findUserById(user_id);
        Admin OldAdmin= adminRepository.findAdminById(admin_id);
        Plan plan= planRepository.findPlanById(plan_id);

        if (plan == null ){
            throw new ApiException("Plan not found");
        }

        if (OldUser== null){
            throw new ApiException("user id not found");
        }

        if(OldAdmin==null ){
            throw new ApiException(("Admin id not found"));
        }

        ticketService.addTicket(ticket);
        ticketService.assignUserToTicket(user_id, ticket.getId());
        ticketService.assignAdminToTicket(admin_id, ticket.getId());
        ticketService.assignPlanToTicket(plan_id, ticket.getId());
        planService.assignAdminToPlan(admin_id,plan_id);


    }


    public List<Ticket> getallticketbyid(Integer user_id){
        User user=userRepository.findUserById(user_id);
        if (user==null){
            throw new ApiException("user id not found");
        }
        List<Ticket> tickets= ticketRepository.findTicketByUser(user);

        return tickets;
    }


    public String  CheckRespoens(Integer ticket_id){
        Ticket ticket = ticketRepository.findTicketById(ticket_id);

        if (ticket==null){
            throw new ApiException("ticket id not found");
        }
        if(ticket.getRespones() == null){  throw new ApiException("No reopens yet");}

        return ticket.getRespones();
    }




    public void addplan(Integer pakage_id ,Integer user_id){
        Package aPackage=packageRepository.findPackageById(pakage_id);

        if (aPackage==null){
            throw new ApiException("package id not found");
        }

        Plan plan = new Plan();

        plan.setName(aPackage.getName());
        plan.setDestination(aPackage.getDestination());
        plan.setDuration(aPackage.getDuration());
        plan.setCategory(aPackage.getCategory());
        plan.setHotel(aPackage.getHotel());
        plan.setHotelStars(plan.getHotelStars());
        plan.setFlightTicket(aPackage.getFlightTicket());
        plan.setTotalPrice(aPackage.getTotalPrice());
        plan.setNumpersons(aPackage.getNumpersons());
        plan.setStatus("pending");
        planRepository.save(plan);


        planService.assignPackageToPlan(pakage_id,plan.getId());
        planService.assignUserToPlan(user_id,plan.getId());


    }

    public void ChangStatusOfPlan(Integer planId)
    {
        Plan plan=planRepository.findPlanById(planId);
        if (plan == null ){
            throw new ApiException("Plan not found");
        }
        plan.setStatus("approve");
        planRepository.save(plan);
    }


    public List<Plan> getAllApprovePlan(Integer user_id) {
        User user = userRepository.findUserById(user_id);
        if (user == null) {
            throw new ApiException("not found");

        }
        List<Plan> plan = planRepository.findPlanByStatusAndUser("approve", user);

        return plan;
    }





}
