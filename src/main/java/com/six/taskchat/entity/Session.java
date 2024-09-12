package com.six.taskchat.entity;

import java.io.Serializable;

/**
 * The persistent class for the messages database table.
 * 
 */
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	private String uid;

	public Session(String uid) {
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}