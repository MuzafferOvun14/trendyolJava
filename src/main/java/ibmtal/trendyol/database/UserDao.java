package ibmtal.trendyol.database;

import org.springframework.data.jpa.repository.JpaRepository;

import ibmtal.trendyol.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
