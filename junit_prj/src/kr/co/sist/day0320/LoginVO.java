package kr.co.sist.day0320;

import java.sql.Date;

public class LoginVO {
	private String id,pass,name;
	private Date input_date;
	
	public LoginVO() {
		
	}//LoginVO
	

	public LoginVO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInput_date() {
		return input_date;
	}

	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", pass=" + pass + ", name=" + name + ", input_date=" + input_date + "]";
	}
	
	
}
