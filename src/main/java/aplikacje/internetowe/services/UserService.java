package aplikacje.internetowe.services;

import java.util.List;

import aplikacje.internetowe.domain.Task;
import aplikacje.internetowe.domain.User;

public interface UserService {
	
	void add(User u);
	List<User> showAll();
	User getById(Long id);
	void changeUserStatus(Long id);
	void del(Long id);
	List<Task> showUserTask(User u);
}
