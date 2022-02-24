package com.org.jwtsecurity.services;

import com.org.jwtsecurity.domain.Category;
import com.org.jwtsecurity.exceptions.EtBadRequestException;
import com.org.jwtsecurity.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {
    /**
     * Permet de lister les categories de l'utilisateur.
     * @param userId
     * @return {categories}.
     */
    List<Category> fetchAllCategories(Integer userId);

    /**
     * Permet  de lister une categorie de l'utilisateur connecté.
     * @param userId
     * @param categoryId
     * @return {Categorie}.
     * @throws EtResourceNotFoundException
     */
    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    /**
     * Permet d'ajouter une categorie.
     * @param userId
     * @param title
     * @param description
     * @return {Categorie}
     * @throws EtBadRequestException
     */
    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;

    /**
     * Permet de modifier une catégorie.
     * @param userId
     * @param categoryId
     * @param category
     * @throws EtBadRequestException
     */
    void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;

    /**
     * Permet de supprimer les categorie en fonction des transactions.
     * @param userId
     * @param categoryId
     * @throws EtResourceNotFoundException
     */
    void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

}
