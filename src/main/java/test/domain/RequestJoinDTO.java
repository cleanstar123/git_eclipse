package test.domain;

public class RequestJoinDTO {
	private String id;
	private String password;
	private String name;
	private String gender;
	
	public RequestJoinDTO() {
		// TODO Auto-generated constructor stub
	}

	public RequestJoinDTO(String id, String password, String name, String gender) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
