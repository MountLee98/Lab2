package aplikacje.internetowe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import aplikacje.internetowe.domain.User;


public interface UserRepo extends JpaRepository<User, Long>{

}
