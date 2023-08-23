package com.example.tripplanner.Controller;

import com.example.tripplanner.Model.Ticket;
import com.example.tripplanner.Service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/get")
    public ResponseEntity getAllTicket()
    {
        return ResponseEntity.status(200).body(ticketService.getAllTicket());
    }
    @PostMapping("/add")
    public ResponseEntity addTicket(@Valid @RequestBody Ticket ticket)
    {
        ticketService.addTicket(ticket);
        return ResponseEntity.status(200).body("The ticket is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTicket(@PathVariable Integer id,@Valid @RequestBody Ticket ticket)
    {
        ticketService.updateTicket(id,ticket);
        return ResponseEntity.status(200).body("The ticket is updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTicket(@PathVariable Integer id)
    {
        ticketService.deleteTicket(id);
        return ResponseEntity.status(200).body("The ticket is deleted");
    }

    // Assign User To Ticket (One to Many)
    @PostMapping("/{user_id}/assignuser/{ticket_id}")
    public ResponseEntity assignUserToTicket(@PathVariable Integer user_id , @PathVariable Integer ticket_id){
        ticketService.assignUserToTicket(user_id,ticket_id);
        return ResponseEntity.status(200).body("User assign to ticket.");
    }


    // Assign Admin To Ticket (One to Many)
    @PostMapping("/{admin_id}/assignadmin/{ticket_id}")
    public ResponseEntity assignAdminToTicket(@PathVariable Integer admin_id , @PathVariable Integer ticket_id){
        ticketService.assignAdminToTicket(admin_id,ticket_id);
        return ResponseEntity.status(200).body("Admin assign to ticket.");
    }

}
