package aplikacje.internetowe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplikacje.internetowe.domain.Task;
import aplikacje.internetowe.domain.User;
import aplikacje.internetowe.repo.TaskRepo;
import aplikacje.internetowe.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	TaskRepo taskRepo;
	
	//tworzenie nowego użytkownika
	@Override
	public void add(User u) {
		// TODO Auto-generated method stub
		userRepo.save(u);
	}

	//zwrócenie wszystkich użytkowników
	@Override
	public List<User> showAll() {
		// TODO Auto-generated method stub
		List<User> res = userRepo.findAll();
		if(res == null)
			res = new ArrayList<>();
		return res;
	}

	//szukanie użytkownika po id
	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> b = showAll().stream().filter(x -> x.getUserId() == id).findFirst();
		if(b.isPresent())
			return b.get();
		return null;
	}

	//zmiana statusu użytkownika na przeciwny
	@Override
	public void changeUserStatus(Long id) {
		// TODO Auto-generated method stub
		User u = getById(id);
		if(u.getStatus() == false) {
			u.setStatus(true);
		} else {
			u.setStatus(false);
		}
	}

	//usunięcie użytkownika i powiązanych z nim zadań
	@Override
	public void del(Long id) {
		// TODO Auto-generated method stub
		User u = getById(id);
		List<Task> taskList = showUserTask(u);
		taskList.stream().forEach(x -> taskRepo.delete(x));
		userRepo.delete(u);
	}

	//pobranie listy zadań danego użytkownika
	@Override
	public List<Task> showUserTask(User u) {
		// TODO Auto-generated method stub
		List<Task> res = taskRepo.findAll().stream().filter(x -> x.getUser() == u).collect(Collectors.toList());
		if(res == null)
			res = new ArrayList<>();
		return res;
	}
	
	

}
