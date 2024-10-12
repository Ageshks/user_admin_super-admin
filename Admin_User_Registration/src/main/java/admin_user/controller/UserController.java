package admin_user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repositories.UserRepository;
import admin_user.service.UserService;               // Import your User entity

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;


	@GetMapping("/index")
	public String index(){
		return "index";
	}
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/super-admin-page")
	public String superAdminPage(Model model, Principal principal) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    model.addAttribute("user", userDetails);

	// Fetch user info from repository
    User user = userRepository.findByEmail(userDetails.getUsername());
    

	model.addAttribute("adminUser", userDetails);
    // Add user details to the model
    model.addAttribute("user", user);

	List<User> users = userRepository.findAll();
	model.addAttribute("users",users);

    return "super-admin";  // Ensure "super-admin.html" exists in the templates folder
	}


	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}

	@GetMapping("/admin-page")
	public String adminPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		
    // Fetch user info from repository
    User user = userRepository.findByEmail(userDetails.getUsername());
    

	model.addAttribute("adminUser", userDetails);
    // Add user details to the model
    model.addAttribute("user", user);

	List<User> users = userRepository.findByRole("USER");
	model.addAttribute("users",users);

    return "admin"; // Ensure 'admin.html' exists
	}

	@PostMapping("/admin/delete-user/{id}")
		public String deleteUser(@PathVariable("id") Long id){
			userService.deleteUserById(id);
			return "redirect:/admin-page";
		}
	
	@PostMapping("/super-admin/delete-user/{id}")
		public String deleteUser(@PathVariable("id") Long id){
			userService.deleteUserById(id);
			return "redirect:/super-admin-page";
		}





}
