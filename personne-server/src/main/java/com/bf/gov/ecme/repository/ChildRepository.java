package com.bf.gov.ecme.repository;

import com.bf.gov.ecme.model.Child;
import com.bf.gov.ecme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
    Set<Child> findAllByParent(User parent);

}