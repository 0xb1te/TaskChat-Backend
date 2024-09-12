package com.six.taskchat.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name = "messages")
@NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
	private Integer id;

	private String author;

	private String content;

	@Column(name = "created_at")
	private Timestamp createdAt;

	// bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	public Message() {
	}

	public Message(Long id, String author, Long categoryId) {
		this.id = id.intValue(); // Assuming the id is Integer in your entity
		this.author = author;
		this.category = new Category(); // Create a new Category
		this.category.setId(categoryId.intValue()); // Set the category ID
	}

	public Message(Integer id, String author, String content, Timestamp createdAt, Category category) {
		super();
		this.id = id;
		this.author = author;
		this.content = content;
		this.createdAt = createdAt;
		this.category = category;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}