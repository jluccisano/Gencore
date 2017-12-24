package com.gencore.backend.java.security;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.service.admin.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService = null;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, DataAccessException {

        login = login.toLowerCase();

        UserProfile user = null;

        try {

            user = userService.getUserByLogin(login);

        } catch (Throwable t) {
            throw new BadCredentialsException("bad.credentials");
        }

        user.setLastAccessDate(Calendar.getInstance().getTime());

        userService.updateUser(user);

        // Set <UserRole> roles = user.getRoles();

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        // Iterator<UserRole> iter = roles.iterator();

        // while (iter.hasNext()) {
        //			 
        // UserRole userRole = (UserRole)iter.next();
        //			 
        // authorities.add( new GrantedAuthorityImpl ( userRole.getRole() ) );
        // }

        authorities.add(new GrantedAuthorityImpl(user.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(login, user.getPassword(), user.isEnabled(),
                true, true, true, authorities);
    }

}
