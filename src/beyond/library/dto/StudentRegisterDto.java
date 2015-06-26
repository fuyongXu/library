package beyond.library.dto;

import org.springframework.stereotype.Component;

@Component
public class StudentRegisterDto {

	private String name;
	private String password;
	private String repassword;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRepassword(String repassword) {
	    this.repassword = repassword;
	}

	public String getRepassword() {
	    return repassword;
	}
}
