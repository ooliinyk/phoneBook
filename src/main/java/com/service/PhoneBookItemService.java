package com.service;

import com.entity.PhoneBookItem;

import java.util.List;

/**
 * Created by user on 15.04.2016.
 */
public interface PhoneBookItemService {

    PhoneBookItem findById(long id);

    List<PhoneBookItem> findAll();

    void saveDocument(PhoneBookItem phoneBookItem);

    void deleteById(long id);

    void updatePhoneBookItem(PhoneBookItem phoneBookItem);
}
