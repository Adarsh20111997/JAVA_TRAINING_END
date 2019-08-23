package com.visa1.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="campaigns")
public class Campaign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private int id;
	private String title;
	private double target;
	private double donated;
	@Column(name="compaign_deadline")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline = new Date();
	private String status;
	public Campaign() {
		
	}
	public Campaign(int id, String title, int target, int donated, Date deadline, String status) {
		this.id = id;
		this.title = title;
		this.target = target;
		this.donated = donated;
		this.deadline = deadline;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getTarget() {
		return target;
	}
	public void setTarget(double target) {
		this.target = target;
	}
	public double getDonated() {
		return donated;
	}
	public void setDonated(double donated) {
		this.donated = donated;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
