package com.refund.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "requests")
@DynamicInsert
public class Request {
	
	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int request_id;
	@Column (unique=false)  private int employee_id;
	@Column private int manager_id;
	@Column private String request_description;
	@Column private double request_amount;
	@Column private String approval_message;
	@Column private boolean approved;
	@Column private boolean pending;

	public Request(int request_id, int employee_id, int manager_id, String request_description, double request_amount,
			String approval_message, boolean approved, boolean pending) {
		super();
		this.request_id = request_id;
		this.employee_id = employee_id;
		this.manager_id = manager_id;
		this.request_description = request_description;
		this.request_amount = request_amount;
		this.approval_message = approval_message;
		this.approved = approved;
		this.pending = pending;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int employee_id, String request_description, double request_amount) {
		super();
		this.employee_id = employee_id;
		this.request_description = request_description;
		this.request_amount = request_amount;
	}
	
//	for updating status
	public Request(int request_id, boolean approved, boolean pending, String approval_message) {
		super();
		this.request_id = request_id;
		this.approval_message = approval_message;
		this.approved = approved;
		this.pending = false;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getRequest_description() {
		return request_description;
	}

	public void setRequest_description(String request_description) {
		this.request_description = request_description;
	}

	public double getRequest_amount() {
		return request_amount;
	}

	public void setRequest_amount(double request_amount) {
		this.request_amount = request_amount;
	}

	public String getApproval_message() {
		return approval_message;
	}

	public void setApproval_message(String approval_message) {
		this.approval_message = approval_message;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isPending() {
		return pending=true;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", employee_id=" + employee_id + ", manager_id=" + manager_id
				+ ", request_description=" + request_description + ", request_amount=" + request_amount
				+ ", approval_message=" + approval_message + ", approved=" + approved + ", pending=" + pending + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(approval_message, approved, employee_id, manager_id, pending, request_amount,
				request_description, request_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(approval_message, other.approval_message) && approved == other.approved
				&& employee_id == other.employee_id && manager_id == other.manager_id && pending == other.pending
				&& Double.doubleToLongBits(request_amount) == Double.doubleToLongBits(other.request_amount)
				&& Objects.equals(request_description, other.request_description) && request_id == other.request_id;
	}

}