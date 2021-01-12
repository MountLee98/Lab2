package aplikacje.internetowe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplikacje.internetowe.domain.Status;
import aplikacje.internetowe.domain.Task;
import aplikacje.internetowe.domain.Type;
import aplikacje.internetowe.repo.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskRepo taskRepo;

	@Override
	public void add(Task t) {
		// TODO Auto-generated method stub
		taskRepo.save(t);
	}

	@Override
	public Task getByType(Type type) {
		// TODO Auto-generated method stub
		Optional<Task> b = showAll().stream().filter(x -> x.getType() == type).findFirst();
		if(b.isPresent())
			return b.get();
		return null;
	}

	@Override
	public List<Task> showAll() {
		// TODO Auto-generated method stub
		List<Task> res = taskRepo.findAllByOrderByDateAddedDesc();
		if(res == null)
			res = new ArrayList<>();
		return res;
	}

	@Override
	public void changeTaskStatus(Long id, Status status) {
		// TODO Auto-generated method stub
		Task t = getById(id);
		t.setStatus(status);
	}

	@Override
	public void del(Long id) {
		// TODO Auto-generated method stub
		Task t = getById(id);
		taskRepo.delete(t);
	}

	@Override
	public Task getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Task> b = showAll().stream().filter(x -> x.getTaskId() == id).findFirst();
		if(b.isPresent())
			return b.get();
		return null;
	}
	
	

}
