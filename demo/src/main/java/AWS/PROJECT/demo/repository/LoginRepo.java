package AWS.PROJECT.demo.repository;

import AWS.PROJECT.demo.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {
}
