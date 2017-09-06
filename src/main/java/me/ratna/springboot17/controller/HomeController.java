package me.ratna.springboot17.controller;

import me.ratna.springboot17.models.User;
import me.ratna.springboot17.models.Role;
import me.ratna.springboot17.UserService;
import me.ratna.springboot17.repositories.RoleRepository;
import me.ratna.springboot17.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import javax.management.relation.Role;
import javax.validation.Valid;

//@Controller
//public class HomeController {
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
    @Controller
    public class HomeController {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String showRegisterationPage(Model model){
        model.addAttribute("user",new User());
        return "registeration";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegisterationPage(@Valid @ModelAttribute("user") User user,BindingResult result,
                                           Model model){
        model.addAttribute("user", new User());
        if(result.hasErrors()){
            return "registeration";
        }
        else {
            userService.saveUser(user);
            model.addAttribute("message", "User Account Successfully Created");
        }
            return "index";


    }
    //--------------------------------------------------------------------------

//    @RequestMapping("/testRoles")
//    public @ResponseBody
//    String showRoles()
//    {
//        Iterable <Role> r = roleRepository.findAll();
//        String x="<h2>ROLE DETAILS</h2>";
//        for(Role item:r)
//        {
//            x+="Role details:"+item.getRole()+" has an ID of "+item.getId()+"<br/>";
//        }
//
//        Role findR = roleRepository.findByRole("ADMIN");
//        x+=findR.getRole()+" was found with an ID of "+findR.getId();
//        return x;
//    }
//    @RequestMapping("/adduser")
//    public @ResponseBody String addUser(){
//        User u = new User();
//        u.setEmail("someone@somewhere.com");
//        u.setUsername("newuser");
//        u.setPassword("password");
//        u.setEnabled(true);
//        u.addRole(roleRepository.findByRole("ADMIN"));
//        userRepository.save(u);
//        return "User added";
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationPage(Model model){
//        model.addAttribute("user", new User());
//        return "registration";
//    }
//    @PostMapping("/register")
//    public String processRegistrationPage(@Valid User user, BindingResult result,Model model){
//        model.addAttribute("user", user);
//        if(result.hasErrors()){
//            return "registration";
//        }else{
//            userService.saveUser(user);
//            model.addAttribute("message","User Account Successfully Created");
//        }
//        return "index";
//    }
//
//    public void addDefaults(){
//        User user1 = new User();
//        user1.setId(1);
//        user1.setEmail("jim@jim.com");
//        user1.setEnabled(true);
//        user1.setFirstName("Jim");
//        user1.setLastName("Jimmerson");
//        user1.setPassword("password");
//        user1.setUsername("jim");
//
//        User user2 = new User();
//        user2.setId(2);
//        user2.setEmail("bob@bob.com");
//        user2.setEnabled(true);
//        user2.setFirstName("Bob");
//        user2.setLastName("Bobberson");
//        user2.setPassword("password");
//        user2.setUsername("bob");
//
//        User user3 = new User();
//        user3.setId(3);
//        user3.setEmail("admin@admin.com");
//        user3.setEnabled(true);
//        user3.setFirstName("Admin");
//        user3.setLastName("User");
//        user3.setPassword("password");
//        user3.setUsername("admin");
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//
//        Role role1 = new Role();
//        role1.setId(1);
//        role1.setRole("USER");
//
//        Role role2 = new Role();
//        role2.setId(2);
//        role2.setRole("ADMIN");
//
//        roleRepository.save(role1);
//        roleRepository.save(role2);
//
//        user1.addRole(role1);
//        user2.addRole(role1);
//        user3.addRole(role1);
//        user3.addRole(role2);
//
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//    }
}
