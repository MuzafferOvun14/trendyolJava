package ibmtal.trendyol.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ibmtal.trendyol.business.services.UserService;
import ibmtal.trendyol.core.result.Result;
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
	public Result<User> addUserDto(@RequestBody UserAddDto userAddDto) {
		return this.userService.addUserDto(userAddDto);
	}	
}
