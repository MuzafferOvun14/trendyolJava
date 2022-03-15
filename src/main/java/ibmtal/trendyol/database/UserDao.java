package ibmtal.trendyol.database;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import ibmtal.trendyol.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	ArrayList<User> getByUsername(String username);
}
