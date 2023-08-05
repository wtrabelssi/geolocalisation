package com.example.demo.model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mobile {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int num ;
	private int cin ;
	private Blob photo;
	private int altitude ;
	private int langtitude;
	private boolean processed;
	public int getNum() {
		return num;
	}
	
	public Mobile() {}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getLangtitude() {
		return langtitude;
	}
	public void setLangtitude(int langtitude) {
		this.langtitude = langtitude;
	}
	public Mobile(int num, int cin, Blob photo, int altitude, int langtitude) {
		this.num = num;
		this.cin = cin;
		this.photo = photo;
		this.altitude = altitude;
		this.langtitude = langtitude;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
}
