package com.example.tripplanner.Service;

import com.example.tripplanner.ApiResponse.ApiException;
import com.example.tripplanner.Model.User;
import com.example.tripplanner.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository ;


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




}
