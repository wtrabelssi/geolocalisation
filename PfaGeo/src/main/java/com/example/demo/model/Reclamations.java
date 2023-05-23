package com.example.demo.model;


import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Reclamations {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	
         private int num_rec;
         private int cin;
         private String localisation;
         private Blob photo ;
         private int etat ;
         
         
         public Reclamations() {
     		// default constructor
     	}
         
		public int getNum_rec() {
			return num_rec;
		}
		public void setNum_rec(int num_rec) {
			this.num_rec = num_rec;
		}
		public int getCin() {
			return cin;
		}
		public void setCin(int cin) {
			this.cin = cin;
		}
		public String getLocalisation() {
			return localisation;
		}
		public void setLocalisation(String localisation) {
			this.localisation = localisation;
		}
		public Blob getPhoto() {
			return photo;
		}
		public void setPhoto(Blob photo) {
			this.photo = photo;
		}
		public int getEtat() {
			return etat;
		}
		public void setEtat(int etat) {
			this.etat = etat;
		}
		public Reclamations(int num_rec, int cin, String localisation, Blob photo, int etat) {
			this.num_rec = num_rec;
			this.cin = cin;
			this.localisation = localisation;
			this.photo = photo;
			this.etat = etat;
		}
		
		
}