package com.example.tripplanner.Repository;

import com.example.tripplanner.Model.Admin;
import com.example.tripplanner.Model.Ticket;
import com.example.tripplanner.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    Ticket findTicketById(Integer id);

    List<Ticket> findTicketByUser(User user);

    List<Ticket> findTicketByAdmin(Admin admin);
}
