package ibmtal.trendyol.dto;

public class CompanyAddDto {
	private String username;
	private String password;
	private String rePassword;
	private String companyName;
	private String adress;
	private String phone;
	private String email;
	private String website;
	public CompanyAddDto() {
		super();
	}
	public CompanyAddDto(String username, String password, String rePassword, String companyName, String adress,
			String phone, String email, String website) {
		super();
		this.username = username;
		this.password = password;
		this.rePassword = rePassword;
		this.companyName = companyName;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
