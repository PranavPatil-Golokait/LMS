package com.sas.SalesAnalysisSystem.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.SalesAnalysisSystem.service.UserService;
import com.sas.SalesAnalysisSystem.model.User;

@RestController
@RequestMapping("/hometest")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUser() {
		System.out.println("getting users");
		return this.userService.getUsers();	
	}
//	@GetMapping("/{x}")
//	public void pathvariabletest(@PathVariable("x") String x) {
//		System.out.println(x);
//	}
	
	@GetMapping("currentuser")
		public String getLoggedInUser(Principal principal) {
			return principal.getName();
		}	
}
