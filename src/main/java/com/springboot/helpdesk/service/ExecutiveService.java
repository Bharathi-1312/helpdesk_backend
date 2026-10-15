package com.springboot.helpdesk.service;

import com.springboot.helpdesk.Repository.ExecutiveRepository;
import com.springboot.helpdesk.Repository.ManagerRepository;
import com.springboot.helpdesk.Repository.UserRepository;
import com.springboot.helpdesk.dto.request.ExecutiveDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.ExecutiveMapper;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.model.Manager;
import com.springboot.helpdesk.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExecutiveService {
    private final ExecutiveRepository executiveRepository;
private final UserRepository userRepository;
private final UserService userService;
private final PasswordEncoder passwordEncoder;

private final ManagerRepository managerRepository;

//    public void add(@Valid ExecutiveDto executiveDto, Long managerId) {
//        // Step 0: Fetch manager from DB using managerId
//        Optional<Manager> optional =  managerRepository.findById(managerId);
//        if(optional.isEmpty())
//            throw new ResourceNotFoundException("Manager id Invalid");
//        Manager manager = optional.get();


    public void add(@Valid ExecutiveDto executiveDto, String managerUsername) {
        // Step 0: Fetch manager from DB using managerUsername
        Manager manager =  managerRepository.getByUsername(managerUsername);

        // Step 1: Prepare User object and save it in DB
        /*
        Executive
            User user <-- User must go in DB first and then Executive next
        * */
        User user = userService.getUserObj(  // <-- this is a full created user obj with id
                executiveDto.username(),
                executiveDto.password(),
                Role.EXECUTIVE
        );

        // Step 1.5 Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Step Map ExecutiveDto to Executive entity
        Executive executive = ExecutiveMapper.mapDtoToEntity(executiveDto);
        // Step 3: Attach the User and Manager to Executive
        executive.setUser(user);
        executive.setManager(manager);

        // Step 4: Save executive and return
         executiveRepository.save(executive);
    }
}
