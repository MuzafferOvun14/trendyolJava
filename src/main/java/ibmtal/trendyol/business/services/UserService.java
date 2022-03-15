package ibmtal.trendyol.business.services;

import java.util.ArrayList;

import ibmtal.trendyol.core.result.Result;
import ibmtal.trendyol.dto.UserAddDto;
import ibmtal.trendyol.entity.User;

public interface UserService {
	ArrayList<User> getAll();
	Result<User> addUser(User user);
	Result<User> addUserDto(UserAddDto userAddDto);
	Result<User> addCompany(User user);
	Result<User> getCompany(Integer id);
	Result<User> getUser(Integer id);
}
