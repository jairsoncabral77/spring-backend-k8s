package squad.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import squad.api.model.User;

@RestController
public class UserService {

	@PostMapping("/user")
	public User addUser(User user) {
		// TODO implement it
		return null;
	}
	
	@GetMapping("/user/{id}")
	public User addUser(@PathVariable String id) {
		// TODO implement it
		return new User(1L, "First User");
	}	
}
