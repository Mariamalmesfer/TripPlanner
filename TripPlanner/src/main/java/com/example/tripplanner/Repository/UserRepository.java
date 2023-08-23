package com.example.tripplanner.Repository;

import com.example.tripplanner.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById (Integer id);
}
