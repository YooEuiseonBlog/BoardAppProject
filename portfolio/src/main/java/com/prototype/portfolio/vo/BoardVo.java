package com.prototype.portfolio.vo;

import java.util.Date;

public class BoardVo {
	private int bno;
	private String title;
	private String contents;
	private String author;
	private Date post_date;
	private int views;
	private int likes;
	private int tap_num;
	private String picture;
	private String file;
	private String nickname;
	
	public BoardVo() {
		super();
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", title=" + title + ", contents=" + contents + ", author=" + author
				+ ", post_date=" + post_date + ", views=" + views + ", likes=" + likes + ", tap_num=" + tap_num
				+ ", picture=" + picture + ", file=" + file + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getTap_num() {
		return tap_num;
	}

	public void setTap_num(int tap_num) {
		this.tap_num = tap_num;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
