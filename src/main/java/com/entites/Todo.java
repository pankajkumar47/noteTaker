package com.entites;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notes")
public class Todo {
	@Id
	private int id;
	private String title;
	@Column(length = 1500)
	private String content;
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = new Random().nextInt(1000);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo( String title, String content, Date addedDate) {
		super();
		this.id = new Random().nextInt(10000);
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", content=" + content + ", addedDate=" + addedDate + "]";
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	
}
