package squad.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import squad.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
