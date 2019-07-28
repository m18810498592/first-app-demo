package firstappdemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @author wcz
 * @date 2019-06-07 23:24
 **/
public class User {

	@JsonIgnore
	private int id;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;

	@JsonIgnore
	private String password;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String phonenumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
	private Date birthday;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
