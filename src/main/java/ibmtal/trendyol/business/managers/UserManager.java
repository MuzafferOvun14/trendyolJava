package ibmtal.trendyol.business.managers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibmtal.trendyol.business.services.UserService;
import ibmtal.trendyol.core.result.Result;
import ibmtal.trendyol.core.result.ResultItem;
import ibmtal.trendyol.database.UserDao;
import ibmtal.trendyol.dto.UserAddDto;
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
		if(result.getSuccess()!=false) {
			this.userDao.save(user);
		}
		return result;
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
	@Override
	public Result<User> addUserDto(UserAddDto userAddDto) {
		Result<User> result=new Result<User>();
		if(userAddDto.getUsername().isBlank()==true) {
			result.setSuccess(false);
			result.getErrors().add(
			  new ResultItem("username","Kullanıcı adı boş")
			);
		}
		else if(this.userDao.getByUsername(
					userAddDto.getUsername()).isEmpty()==false
				) 
		{
			result.setSuccess(false);
			result.getErrors().add(
			  new ResultItem("username","Kullanıcı adı sistemde kayıtlı")
			);			
		}
		//gelen password değeri boş ise hata oluştur
		if(userAddDto.getPassword().isBlank()==true) {
			result.setSuccess(false);//işlem başarısız
			result.getErrors().add(
			  new ResultItem("password","Şifre girmediniz")
			);//password ile ilgili hata mesajı				
		}
		if(userAddDto.getRePassword().isBlank()==true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("rePassword", "Şifre Tekrar alanını boş geçemezsiniz"));
		}
		
		else if(userAddDto.getPassword()
				.equals(userAddDto.getRePassword())==false) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("rePassword", "Şifreler uyuşmuyor"));
			
		}
		if(userAddDto.getEmail().isBlank()==true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("email", "Boş Geçilemez"));
		}
		if(result.getSuccess()==true) {
			User user=new User();
			user.setUsername(userAddDto.getUsername());
			user.setPassword(userAddDto.getPassword());
			user.setName(userAddDto.getName());
			user.setSurname(userAddDto.getSurname());
			user.setEmail(userAddDto.getEmail());
			user.setAdress(userAddDto.getAdress());
			user.setPhone(userAddDto.getPhone());
			user.setWebsite(userAddDto.getWebsite());
			user.setUsertype("user");
			this.userDao.save(user);
			ArrayList<User> userlist=new ArrayList<User>();
			userlist.add(user);
			result.setData(userlist);
		}
		return result;
	}

}
