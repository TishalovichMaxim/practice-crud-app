package by.tishalovichm.crudapp.repository;

import by.tishalovichm.crudapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
