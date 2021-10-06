package com.refund.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employee_id;
	@Column private String employee_name;
	@Column private int manager_id;
	@Column private boolean is_manager;
	@Column private String username;
	@Column private String password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_id, String employee_name, int manager_id, boolean is_manager, String username,
			String password) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.manager_id = manager_id;
		this.is_manager = is_manager;
		this.username = username;
		this.password = password;
	}
	
	
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public boolean isIs_manager() {
		return is_manager;
	}

	public void setIs_manager(boolean is_manager) {
		this.is_manager = is_manager;
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

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", manager_id="
				+ manager_id + ", is_manager=" + is_manager + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee_id, employee_name, is_manager, manager_id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employee_id == other.employee_id && Objects.equals(employee_name, other.employee_name)
				&& is_manager == other.is_manager && manager_id == other.manager_id
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	

}