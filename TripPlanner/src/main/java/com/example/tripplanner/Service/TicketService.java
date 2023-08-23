package com.example.tripplanner.Service;

import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Model.Plan;
import com.example.tripplanner.Model.Ticket;
import com.example.tripplanner.Model.User;
import com.example.tripplanner.Repository.AdminRepository;
import com.example.tripplanner.Repository.TicketRepository;
import com.example.tripplanner.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public List<Ticket> getAllTicket()
    {
        return ticketRepository.findAll();
    }

    public void addTicket(Ticket ticket)
    {
        ticketRepository.save(ticket);
    }

    public void updateTicket(Integer id,Ticket ticket)
    {
        Ticket ticket1=ticketRepository.findTicketById(id);
        if (ticket1==null)
        {
          throw new ApiException("Error,the ticket not found");
        }
        ticket1.setStatus(ticket.getStatus());
        ticket1.setMessage(ticket.getMessage());
        ticketRepository.save(ticket1);
    }

    public void deleteTicket(Integer id)
    {
        Ticket ticket=ticketRepository.findTicketById(id);
        if (ticket==null)
        {
            throw new ApiException("Error,the ticket not found");
        }
        ticketRepository.delete(ticket);
    }




    // Assign User To Ticket (One to Many)
    public void assignUserToTicket(Integer user_id , Integer ticket_id){
        User user = userRepository.findUserById(user_id);
        Ticket ticket = ticketRepository.findTicketById(ticket_id);

        if(user == null || ticket == null ){ throw new ApiException("Can not assign id not found");}

        ticket.setUser(user);

        ticketRepository.save(ticket);

    }


    // Assign Admin To Ticket (One to Many)
    public void assignAdminToTicket(Integer admin_id , Integer ticket_id){
        Admin admin = adminRepository.findAdminById(admin_id);
        Ticket ticket = ticketRepository.findTicketById(ticket_id);

        if(admin == null || ticket == null ){ throw new ApiException("Can not assign id not found");}

        ticket.setAdmin(admin);

        ticketRepository.save(ticket);

    }









}
