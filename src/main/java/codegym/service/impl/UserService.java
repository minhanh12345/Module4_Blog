package codegym.service.impl;

import codegym.model.User;
import codegym.repository.IUserRepo;
import codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    IUserRepo iUserRepo;
    @Override
    public ArrayList<User> findAll() {
        return (ArrayList<User>) iUserRepo.findAll();
    }

    @Override
    public User findById(long id) {
        return iUserRepo.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=iUserRepo.findByUser_name(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(user.getRole());
         UserDetails userDetails=new org.springframework.security.core.userdetails.User(
                 user.getUser_name(),
                 user.getUser_password(),
                 authorities
         );

        return userDetails;
    }
}
