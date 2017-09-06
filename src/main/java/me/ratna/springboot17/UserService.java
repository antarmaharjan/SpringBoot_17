package me.ratna.springboot17;

import me.ratna.springboot17.models.User;
import me.ratna.springboot17.repositories.RoleRepository;
import me.ratna.springboot17.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User countByEmail(String email){
        return userRepository.countByEmail(email);
    }
    public User findByusername(String username){
        return userRepository.findByUsername(username);
    }
    public  void saveUser(User user){
        user.setRoles((Arrays.asList(roleRepository.findByRole("User"))));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveAdmin(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        user.setEnabled(true);
        userRepository.save(user);
    }

}
