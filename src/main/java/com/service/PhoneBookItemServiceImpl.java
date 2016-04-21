package com.service;

import com.dao.PhoneBookItemDao;
import com.entity.PhoneBookItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 15.04.2016.
 */

@Service("PhoneBookItemService")
@Transactional
public class PhoneBookItemServiceImpl implements PhoneBookItemService {


    @Autowired
    PhoneBookItemDao dao;

    public PhoneBookItem findById(long id) {
        return dao.findById(id);
    }

    public List<PhoneBookItem> findAll() {
        return dao.findAll();
    }

    public List<PhoneBookItem> findByName(String name, String login) {
        return dao.findByName(name,login);
    }

    public List<PhoneBookItem> findBySurname(String surnmae, String login) {
        return dao.findBySurname(surnmae,login);
    }

    public List<PhoneBookItem> findByMobPhone(String mobPhone, String login) {
        return dao.findByMobPhone(mobPhone,login);
    }

      public void saveDocument(PhoneBookItem phoneBookItem) {
        dao.save(phoneBookItem);
    }

    public void deleteById(long id) {
        dao.delteById(id);
    }

    public void updatePhoneBookItem(PhoneBookItem phoneBookItem) {
        PhoneBookItem entity=dao.findById(phoneBookItem.getId());
        if(entity!=null){
            entity.setName(phoneBookItem.getName());
            entity.setSurname(phoneBookItem.getSurname());
            entity.setPatronymic(phoneBookItem.getPatronymic());
            entity.setEmail(phoneBookItem.getEmail());
            entity.setAddress(phoneBookItem.getAddress());
            entity.setMobPhone(phoneBookItem.getMobPhone());
            entity.setHomePhone(phoneBookItem.getHomePhone());
             }
    }
}
