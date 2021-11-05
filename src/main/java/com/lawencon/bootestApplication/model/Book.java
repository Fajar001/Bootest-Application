package com.lawencon.bootestApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(indexes = @Index(name = "idx_book", columnList = "authorId, publisherId, bookName, bookPage"), name = "book")
public class Book {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String bookId;
	
	@ManyToOne
	@JoinColumn(name = "authorId")
	private Author authorId;
	
	@ManyToOne
	@JoinColumn(name = "publisherId")
	private Publisher publisherId;
	private String bookName;
	private String bookPage;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Author getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}
	public Publisher getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Publisher publisherId) {
		this.publisherId = publisherId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPage() {
		return bookPage;
	}
	public void setBookPage(String bookPage) {
		this.bookPage = bookPage;
	}
}
