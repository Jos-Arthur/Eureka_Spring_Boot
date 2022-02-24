package com.org.jwtsecurity.services;

import com.org.jwtsecurity.domain.User;
import com.org.jwtsecurity.exceptions.EtAuthException;

public interface UserService {
    /**
     * Permet de verifier l'email et le mot passe saisie par l'utilisateur.
     * @param email
     * @param password
     * @return
     * @throws EtAuthException
     */
    User validateUser(String email, String password) throws EtAuthException;

    /**
     * Permet d'enregistrer un nouvel utilisateur.
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @return {User}.
     * @throws EtAuthException
     */
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
