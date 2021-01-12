package aplikacje.internetowe.services;

import java.util.List;

import aplikacje.internetowe.domain.Status;
import aplikacje.internetowe.domain.Task;
import aplikacje.internetowe.domain.Type;

public interface TaskService {

	void add(Task t);
	List<Task> showAll();
	Task getByType(Type type);
	Task getById(Long id);
	void changeTaskStatus(Long id, Status status);
	void del(Long id);
}
