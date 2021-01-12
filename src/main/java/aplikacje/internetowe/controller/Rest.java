package aplikacje.internetowe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aplikacje.internetowe.domain.Status;
import aplikacje.internetowe.domain.Task;
import aplikacje.internetowe.domain.Type;
import aplikacje.internetowe.domain.User;
import aplikacje.internetowe.services.TaskService;
import aplikacje.internetowe.services.UserService;

@RestController
public class Rest {

	@Autowired
	UserService userService;
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("allusers")
	List<User> users() {
		List<User> list = userService.showAll();
		return list;
	}
	
	@PostMapping("adduser")
	void addUser(@RequestBody User user) {
		userService.add(user);
	}
	
	@GetMapping("/user/{id}")
	User getUserById (@PathVariable Long id){
		return userService.getById(id);
	}
	
	@PostMapping("/deleteuser/{id}")
	void deleteUser(@PathVariable Long id) {
		userService.del(id);
	}
	
	@PostMapping("changeuserstatus/{id}")
	void changeUserStatus(@PathVariable Long id) {
		userService.changeUserStatus(id);
	}
	
	@PostMapping("addtask")
	void addTask(@RequestBody Task task) {
		taskService.add(task);
	}
	
	@GetMapping("alltasks")
	List<Task> tasks() {
		List<Task> list = taskService.showAll();
		return list;
	}
	
	@GetMapping("/task/{type}")
	Task getTaskByType (@PathVariable Type type){
		return taskService.getByType(type);
	}
	
	@PostMapping("/deletetask/{id}")
	void deleteTask(@PathVariable Long id) {
		taskService.del(id);
	}
	
	@PostMapping("/type/{id}/{status}")
	void changeTaskStatus(@RequestBody Long id, @RequestBody Status status) {
		taskService.changeTaskStatus(id, status);
	}
}
