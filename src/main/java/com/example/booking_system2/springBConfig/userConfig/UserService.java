package com.example.booking_system2.springBConfig.userConfig;

import com.example.booking_system2.users.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userToCreate) {
        if(userToCreate.typeOfPerson().equals("New_Person")){
            NewPerson newPerson = new NewPerson();
            newPerson.setBalance(userToCreate.balance());
            newPerson.setEmail(userToCreate.email());
            User savedUser = userRepository.save(newPerson);
              return new UserResponse(
                      savedUser.getUserId(),
                      savedUser.getEmail(),
                      savedUser.getCountBooking(),
                      savedUser.getBalance()
              );
        }else if(userToCreate.typeOfPerson().equals("Active_Person")){
            ActivePerson activePerson = new ActivePerson();
            activePerson.setBalance(userToCreate.balance());
            activePerson.setEmail(userToCreate.email());
            User savedUser1 = userRepository.save(activePerson);
             return new UserResponse(
                     savedUser1.getUserId(),
                     savedUser1.getEmail(),
                     savedUser1.getCountBooking(),
                     savedUser1.getBalance()
             );
        }else if(userToCreate.typeOfPerson().equals("VIP_Person")){
            VIPPerson vipPerson = new VIPPerson();
            vipPerson.setBalance(userToCreate.balance());
            vipPerson.setEmail(userToCreate.email());
            User savedUser2 = userRepository.save(vipPerson);
             return new UserResponse(
                     savedUser2.getUserId(),
                     savedUser2.getEmail(),
                     savedUser2.getCountBooking(),
                     savedUser2.getBalance()
             );
        }
         throw new EntityNotFoundException("user is not found");
    }

    }

