package com.example.tripplanner.Repository;

import com.example.tripplanner.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    Ticket findTicketById(Integer id);
}
