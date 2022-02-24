package com.bf.gov.ecme.service;

import com.bf.gov.ecme.model.Child;
import com.bf.gov.ecme.model.User;
import com.bf.gov.ecme.repository.ChildRepository;
import com.bf.gov.ecme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path="/api/v1")
public class ChildService {
    @Autowired
    ChildRepository childRepository ;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/allChildsByParent/{idParent}")
    public Set<Child> getAllUsers(
            @PathVariable
            int idParent
    ) {
        User parent=userRepository.findById(idParent);
        // System.out.println(parent.getChildren().size());
        // return   parent.getChildren();
        return childRepository.findAllByParent(parent);
    }

    @PostMapping("/createChildWithParent/{idParent}")
    public ResponseEntity<Child> createUser(
            @PathVariable int idParent,
            @RequestBody Child child) {
        User parent=userRepository.findById(idParent);
        child.setParent(parent);
        return new ResponseEntity<Child>(childRepository.save(child), HttpStatus.OK);
    }

}