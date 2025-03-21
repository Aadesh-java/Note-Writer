package com.entity;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notes")
public class Note {
	
	@Id
	private int id;
	private  String title;
	@Column(length = 5000)
	private String content;
	private Date addedDate;
	
	public Note() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  String getTitle() {
		return title;
	}

	public  void setTitle(String title) {
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

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	public Note(String title, String content, Date addedDate) {
		super();
		this.id =new Random().nextInt(10000); 
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", addedDate=" + addedDate + "]";
	}
	
	
	
}
