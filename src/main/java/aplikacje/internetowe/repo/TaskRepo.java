package aplikacje.internetowe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import aplikacje.internetowe.domain.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{
	public List<Task> findAllByOrderByDateAddedDesc();
}
