package model;

import java.util.Date;


public class Employee {
	private Integer emp_no;
	private Date birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	private Date hire_date;
	
	public Employee() {}
	
	public Employee(Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
		this.birth_date = birthDate;
		this.first_name = firstName;
		this.last_name = lastName;
		this.gender = gender;
		this.hire_date = hireDate;
	}
	
	public void setEmp_no(Integer empNo) {
		this.emp_no = empNo;
	}
	public Integer getEmp_no() {
		return this.emp_no;
	}
	
	public void setBirth_date(Date birthDate) {
		this.birth_date = birthDate;
	}
	public Date getBirth_date() {
		return this.birth_date;
	}
	
	public void setFirst_name(String firstName) {
		this.first_name = firstName;
	}
	public String getFirst_name() {
		return this.first_name;
	}
	
	public void setLast_name(String lastName) {
		this.last_name = lastName;
	}
	public String getLast_name() {
		return this.last_name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return this.gender;
	}
	
	public void setHire_date(Date hireDate) {
		this.hire_date = hireDate;
	}
	public Date getHire_date() {
		return this.hire_date;
	}
}
