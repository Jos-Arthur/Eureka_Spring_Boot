package com.bf.gov.ecme.repository;

import com.bf.gov.ecme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAll();
    public User findById(int id);
    public void deleteById(int id);
}
