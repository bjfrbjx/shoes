package cn;
// Generated 2019-4-22 19:53:13 by Hibernate Tools 5.4.2.Final

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

	private Integer id;
	private String name;
	private String sex;
	private String password;
	private String email;

	public Users() {
	}

	public Users(String name, String sex, String password, String email) {
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.email = email;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
