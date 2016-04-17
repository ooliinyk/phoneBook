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

    void delteById(long id);



}
