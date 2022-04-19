package ibmtal.trendyol.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ibmtal.trendyol.business.services.UserService;
import ibmtal.trendyol.core.result.Result;
import ibmtal.trendyol.dto.CompanyAddDto;
import ibmtal.trendyol.dto.LoginDto;
import ibmtal.trendyol.dto.UserAddDto;
import ibmtal.trendyol.entity.User;
@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public Result<User> addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	@PostMapping("/adduser")
	@GetMapping
	public Result<User> addUserDto(@RequestBody UserAddDto userAddDto) {
		return this.userService.addUserDto(userAddDto);
	}	
	@PostMapping("/addCompany")
	@GetMapping
	public Result<User> addCompanyDto(@RequestBody CompanyAddDto companyAddDto ) {
		return this.userService.addCompanyDto(companyAddDto);
	}	
	@PostMapping("/loginUser")
	@GetMapping
	public Result<User> loginUser(@RequestBody LoginDto loginDto ) {
		return this.userService.login(loginDto);
	}	
}
