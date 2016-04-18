package com.dao;

import com.entity.PhoneBookItem;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 15.04.2016.
 */

@Repository("PhoneBookItemDai")
public class PhoneBookItemImpl extends AbstractDao<Long, PhoneBookItem> implements PhoneBookItemDao {


    public void save(PhoneBookItem phoneBookItem) {
        persist(phoneBookItem);
    }

    public List<PhoneBookItem> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("name"));
        return (List<PhoneBookItem>)criteria.list();
    }



    public PhoneBookItem findById(long id) {
        return getByKey(id);
    }


    public List<PhoneBookItem> findByName(String name) {
        Criteria criteria = createEntityCriteria();

        criteria.add((Restrictions.eq("name", name)));
        return (List<PhoneBookItem>) criteria.list();
    }

    public List<PhoneBookItem> findBySurname(String surname) {
        Criteria criteria = createEntityCriteria();

        criteria.add((Restrictions.eq("surname", surname)));
        return (List<PhoneBookItem>) criteria.list();
    }

    public List<PhoneBookItem> findByMobPhone(String mobPhone) {
//        TypedQuery<AttendeesVO> query = entityManager.createQuery(" select at from AttendeesVO at where at.user.firstName LIKE :searchKeyword",AttendeesVO.class);
//        query.setParameter("searchKeyword", searchKeyword+"%");
//        return query.getResultList();
        return null;
    }


    public void delteById(long id) {
        PhoneBookItem phoneBookItem=getByKey(id);
        delete(phoneBookItem);
    }
}
