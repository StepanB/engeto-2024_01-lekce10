package com.engeto.testcontroller.controller;

import com.engeto.testcontroller.dto.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	private List<User> users = new ArrayList<>();
	public void createDefaultUsers() {
		User user = new User();

		user.setName("Stepan");
		user.setLastName("Bohm");
		user.setUserId(1L);

		User user2 = new User("Karel", "Karel", 2L, "Kaja");
		users.add(user);
		users.add(user2);
		users.add(new User("Dalsi", "Karel", 3L, "Karlicek"));
	}

	@GetMapping("create")
	public void createUsers() {
		createDefaultUsers();
	}
	@GetMapping
	public List<User> getUser() {
		return users;
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		User user = new User("User", "Zadanym ID", id, null);
		users.add(user);
		return user;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		users.add(user);

		if (user == null) {
			return null;
		}
		return user;
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {

	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		users.add(user);
		return user;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity handleException(Exception e) {
		// Můžeme vypsat i do konzole serveru:
		e.printStackTrace();
		return new ResponseEntity<Object>("chyba", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}
}
