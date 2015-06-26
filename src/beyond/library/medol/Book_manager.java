package beyond.library.medol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book_manager {
	
	private String manager_id;
	private String manager_name;
	private String password;

	@Id
	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String managerId) {
		manager_id = managerId;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String managerName) {
		manager_name = managerName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
