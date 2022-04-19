package ibmtal.trendyol.business.managers;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibmtal.trendyol.business.services.UserService;
import ibmtal.trendyol.core.result.Result;
import ibmtal.trendyol.core.result.ResultItem;
import ibmtal.trendyol.database.UserDao;
import ibmtal.trendyol.dto.CompanyAddDto;
import ibmtal.trendyol.dto.LoginDto;
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
		Result<User> result = new Result<User>();
		if (user.getUsername().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("username", "Kullanıcı adı boş geçilemez"));
		}
		if (user.getPassword().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("password", "Şifre boş geçilemez"));
		}
		if (user.getPassword().length() < 8) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("password", "Şifre en az 8 Karakter olmalı"));
		}

		if (user.getEmail().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("email", "Mail Adresi boş geçilemez"));
		}
		if (user.getName().length() < 2) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("name", "Ad belirtmediniz"));
		}
		if (result.getSuccess() != false) {
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
		Result<User> result = new Result<User>();
		if (userAddDto.getUsername().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("username", "Kullanıcı adı boş"));
		} else if (this.userDao.getByUsername(userAddDto.getUsername()).isEmpty() == false) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("username", "Kullanıcı adı sistemde kayıtlı"));
		}
		// gelen password değeri boş ise hata oluştur
		if (userAddDto.getPassword().isBlank() == true) {
			result.setSuccess(false);// işlem başarısız
			result.getErrors().add(new ResultItem("password", "Şifre girmediniz"));// password ile ilgili hata mesajı
		}
		if (userAddDto.getRePassword().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("rePassword", "Şifre Tekrar alanını boş geçemezsiniz"));
		}

		else if (userAddDto.getPassword().equals(userAddDto.getRePassword()) == false) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("rePassword", "Şifreler uyuşmuyor"));

		}
		if (userAddDto.getEmail().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("email", "Boş Geçilemez"));
		}
		if (userAddDto.getName().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("name", "Boş Geçilemez"));
		}
		if (userAddDto.getSurname().isBlank() == true) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("surname", "Soyad Boş Geçilemez"));
		}
		if (result.getSuccess() == true) {
			User user = new User();
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
			ArrayList<User> userlist = new ArrayList<User>();
			userlist.add(user);
			result.setData(userlist);
		}
		return result;
	}

	@Override
	public Result<User> addCompanyDto(CompanyAddDto companyAddDto) {
		Result<User> result = new Result<User>();
		// username kontrolleri
		if (companyAddDto.getUsername().isBlank()) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("username", "Kullanıcı Adı boş geçilemez"));
		} else if (this.userDao.getByUsername(companyAddDto.getUsername()).isEmpty() == false) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("username", "Kullanıcı Adı sistemde kayıtlı"));
		}

		// password kontrolleri
		if (companyAddDto.getPassword().isBlank()) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("password", "şifre Boş Geçilemez"));
		} else if (companyAddDto.getPassword().length() < 8) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("password", "şifre En az 8 Karakter olmalı "));
		}
		if (companyAddDto.getRePassword().equals(companyAddDto.getPassword()) == false) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("rePassword", "şifreler uyuşmuyor"));
		}
		// companyName
		if (companyAddDto.getCompanyName().isBlank()) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("companyName", "Şirket adı boş geçilemez"));

		} else if (this.userDao.getByName(companyAddDto.getCompanyName()).isEmpty() == false) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("companyName", "Şirket adı sistemde kayıtlı"));
		}
		// phone
		if (companyAddDto.getPhone().isBlank()) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("phone", "Telefon numarası girmediniz"));
		}
		// email
		if (companyAddDto.getEmail().isBlank()) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("email", "E-Mail Adresi girmediniz"));
		}
		// adress
		if (companyAddDto.getAdress().isBlank()) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("adress", "Adres Bilgisi girmediniz"));
		}
		// kayıt işlemi
		if (result.getSuccess() == true) {
			User user = new User();
			user.setUsername(companyAddDto.getUsername());
			user.setPassword(companyAddDto.getPassword());
			user.setName(companyAddDto.getCompanyName());
			user.setPhone(companyAddDto.getPhone());
			user.setUsertype("company");
			user.setEmail(companyAddDto.getEmail());
			user.setAdress(companyAddDto.getAdress());
			user.setWebsite(companyAddDto.getWebsite());
			this.userDao.save(user);
		}
		return result;
	}

	@Override
	public Result<User> login(LoginDto loginDto) {
		Result<User> result = new Result<User>();
		User loginUser = new User();
		loginUser = this.userDao.findByUsername(loginDto.getUsername());
		if (loginUser.getUsername().isBlank()) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("username", "Kullanıcı adı hatalı"));
		} else if (loginDto.getPassword().equals(loginUser.getPassword()) == false) {
			result.setSuccess(false);
			result.getErrors().add(new ResultItem("password", "Şifre hatalı"));
		}
		if (result.getSuccess() == true) {
			String metin =loginUser.getUsername()+"ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

			StringBuilder sb = new StringBuilder(6);

			for (int i = 0; i < 30; i++) {
				int index = (int) (metin.length() * Math.random());
				sb.append(metin.charAt(index));
			}
			String registrationcode = sb.toString();
		}
		return result;
	}

}
