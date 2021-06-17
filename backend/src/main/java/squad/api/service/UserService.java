package squad.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import squad.api.data.UserRepository;
import squad.api.model.User;

@RestController
public class UserService {

	@Autowired
	private UserRepository repository;

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		repository.save(user);
		return user;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable long id) {
		return repository.findById(id).orElseThrow();
	}	

	@GetMapping("/users")
	public List<User> getUsers() {
		return repository.findAll();
	}	

}
