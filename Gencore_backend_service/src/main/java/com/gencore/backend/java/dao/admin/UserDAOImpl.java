package com.gencore.backend.java.dao.admin;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.exception.FlexServiceException;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

    public UserProfile getUser(Long id) {
        return (UserProfile) getHibernateTemplate().get(UserProfile.class, id);
    }

    @SuppressWarnings("unchecked")
    public UserProfile getSimpleUser(String id) {

        List list = getHibernateTemplate().find("select firstName , lastName , email from UserProfile where id = ?", id);
        return (UserProfile) list.get(0);
    }

    public UserProfile getUserByLogin(String login) throws FlexServiceException {
        
        UserProfile user = null;
        try {
            HibernateTemplate hibernateTemplate = getHibernateTemplate();
            DetachedCriteria criteria = DetachedCriteria.forClass(UserProfile.class);
            criteria.add(Restrictions.like("login", login));
            hibernateTemplate.setMaxResults(1);
            List<UserProfile> users = hibernateTemplate.findByCriteria(criteria);
            user = users.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new FlexServiceException("user.empty");   
        }
        return user;
    }
    
    public boolean checkUserByLogin(String login) {
        boolean result;      

        UserProfile _user = null;
        try {
            _user = this.getUserByLogin(login);
            result = true;
        } catch (FlexServiceException e) {
            result = false;
        }        
        return result;
    }
    

    @SuppressWarnings("unchecked")
    public UserProfile getUserEmail(String email) throws FlexServiceException {
        
        UserProfile user = null;
        try {
            List<UserProfile> list = getHibernateTemplate().find("from UserProfile where email = ?", email);
            user = (UserProfile) list.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new FlexServiceException("user.empty");
        }
        return user;
    }
    
    @SuppressWarnings("unchecked")
    public boolean checkUserEmail(String email) {

        boolean result;      

        UserProfile _user = null;
        try {
            _user = this.getUserEmail(email);
            result = true;
        } catch (FlexServiceException e) {
            result = false;
        }
        
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<UserProfile> getUsers() {
        return getHibernateTemplate().find("from UserProfile");
    }

    public void insertUser(UserProfile user) {
        getHibernateTemplate().save(user);
    }

    public void deleteUser(UserProfile user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public void deleteUsers(List<UserProfile> users) {
        getHibernateTemplate().deleteAll(users);

    }

    public void updateUser(UserProfile user) {
        getHibernateTemplate().update(user);
    }

}
