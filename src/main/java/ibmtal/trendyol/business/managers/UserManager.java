package ibmtal.trendyol.business.managers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibmtal.trendyol.business.services.UserService;
import ibmtal.trendyol.core.result.Result;
import ibmtal.trendyol.core.result.ResultItem;
import ibmtal.trendyol.database.UserDao;
import ibmtal.trendyol.entity.User;

@Service
public class UserManager implements UserService {
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public ArrayList<User> getAll() {
	return new ArrayList<User>(this.userDao.findAll());
	}

	@Override
	public Result<User> addUser(User user) {
		Result<User> result=new Result<User>();
		if(user.getUsername().isBlank()==true) {
			result.setSuccess(false);
			result.getErrors().add(
			 new ResultItem("username", "Kullanıcı adı boş geçilemez")
			);
		}
		if(user.getPassword().isBlank()==true) {
			result.setSuccess(false);
			result.getErrors().add(
			 new ResultItem("password", "Şifre boş geçilemez")
			);
		}
		if(user.getPassword().length()<8) {
			result.setSuccess(false);
			result.getErrors().add(
			 new ResultItem("password", "Şifre en az 8 Karakter olmalı")
			);
		}
		
		if(user.getEmail().isBlank()==true) {
			result.setSuccess(false);
			result.getErrors().add(
			 new ResultItem("email", "Mail Adresi boş geçilemez")
			);
		}
			
		return null;
	}

	@Override
	public Result<User> addCompany(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<User> getCompany(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<User> getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
