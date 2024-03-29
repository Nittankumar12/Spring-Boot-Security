package com.Railworld.SpringSecurityDemo.service;

import com.Railworld.SpringSecurityDemo.model.User;
import com.Railworld.SpringSecurityDemo.model.UserPrincipal;
import com.Railworld.SpringSecurityDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user = userRepo.findByUsername(username);
         if(user == null){
             System.out.println("User not found");
             throw new UsernameNotFoundException("User 404");
         }
        return new UserPrincipal(user);
    }
}
