package com.org.jwtsecurity.repositories;

import com.org.jwtsecurity.domain.User;
import com.org.jwtsecurity.exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
