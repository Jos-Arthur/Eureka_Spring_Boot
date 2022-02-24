package com.bf.gov.ecme.service;

import com.bf.gov.ecme.model.User;
import com.bf.gov.ecme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class UserService {
    @Autowired
    UserRepository userRepository ;

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(
            @PathVariable
            int id,
            @RequestBody
            User user){
        User user1 = userRepository.findById(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());

        user1.setEmail(user.getEmail());

        user1.setTelephone(user.getTelephone());


        return userRepository.save(user1);
    }


    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){

        User user = userRepository.findById(id);
        if (user!=null) {
            userRepository.deleteById(id);
            return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<String>("User not found",HttpStatus.METHOD_FAILURE);




    }


}
