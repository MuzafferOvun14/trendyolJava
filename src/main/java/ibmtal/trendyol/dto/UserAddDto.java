package ibmtal.trendyol.dto;

public class UserAddDto {
	private String username;
	private String password;
	private String rePassword;
	private String name;
	private String surname;
	private String adress;
	private String phone;
	private String email;
	private String website;
	public UserAddDto() {
		super();
	}
	public UserAddDto(String username, String password, String rePassword, String name, String surname, String adress,
			String phone, String email, String website) {
		super();
		this.username = username;
		this.password = password;
		this.rePassword = rePassword;
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.website = website;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
}
