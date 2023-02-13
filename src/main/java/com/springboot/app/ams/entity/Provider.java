package com.springboot.app.ams.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Provider {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id ;
   
   @NotBlank(message="Name is mandatory")
   @Column(name="name")
   private String name;
   
   @NotBlank(message="Adress is mandatory")
   @Column(name="adress")
   private String adress;
   
   @NotBlank(message="Email is mandatory")
   @Column(name="email")
   private String email;
   
   public Provider () {}
   
   public Provider (String name , String adress , String email) {
	   this.name=name ;
	   this.adress=adress ;
	   this.email=email ;
   }
   
   public void setId(long id) {
	   this.id=id;   
   }
   public long getId() {
	   return id ;
   }
   
   public void setName(String name) {
	   this.name=name;
   }
   
   public String getName() {
	   return name ;
   }
   public void setAdress(String adress) {
	   this.adress=adress;
   }
   public String getAdress() {
	   return adress ;
   }
      public void setEmail(String email) {
	   this.email=email;
   }
   public String getEmail() {
	   return email ;
   }
   @OneToMany(cascade=CascadeType.ALL, mappedBy = "provider")
   private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

   }

