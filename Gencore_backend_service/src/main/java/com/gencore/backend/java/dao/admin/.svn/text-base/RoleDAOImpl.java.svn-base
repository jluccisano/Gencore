package com.gencore.backend.java.dao.admin;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gencore.backend.java.entity.UserRole;

public class RoleDAOImpl extends HibernateDaoSupport implements RoleDAO {

    public void deleteRole(UserRole role) {
        getHibernateTemplate().delete(role);
    }

    public UserRole getRole(Long id) {
        return (UserRole) getHibernateTemplate().get(UserRole.class, id);
    }

    public UserRole getRoleByName(String roleName) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        DetachedCriteria criteria = DetachedCriteria.forClass(UserRole.class);
        criteria.add(Restrictions.like("name", roleName));
        hibernateTemplate.setMaxResults(0);
        List<UserRole> role = hibernateTemplate.findByCriteria(criteria);
        return role.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<UserRole> getRoles() {
        return getHibernateTemplate().find("from UserRole");
    }

    public void insertRole(UserRole role) {
        getHibernateTemplate().saveOrUpdate(role);
    }

    public void updateRole(UserRole role) {
        getHibernateTemplate().update(role);
    }

    @Override
    public void deleteRoles(List<UserRole> roles) {
        getHibernateTemplate().deleteAll(roles);
    }

}
