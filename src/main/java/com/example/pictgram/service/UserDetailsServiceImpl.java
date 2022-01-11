package com.example.pictgram.service;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pictgram.entity.User;
import com.example.pictgram.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    protected static org.jboss.logging.Logger log = LoggerFactory.logger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	log.debug("username={}");

        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is empty");
        }
        User entity = repository.findByUsername(username);

        return entity;
    }

}