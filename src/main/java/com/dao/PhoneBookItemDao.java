package com.dao;

import com.entity.PhoneBookItem;

import java.util.List;

/**
 * Created by user on 15.04.2016.
 */
public interface PhoneBookItemDao {
    void save(PhoneBookItem phoneBookItem);

    List<PhoneBookItem> findAll();

    PhoneBookItem findById(long id);

    List<PhoneBookItem> findByName(String name, String login);

    List<PhoneBookItem> findBySurname(String surname, String login);

    List<PhoneBookItem> findByMobPhone(String mobPhone, String login);

    void delteById(long id);



}
