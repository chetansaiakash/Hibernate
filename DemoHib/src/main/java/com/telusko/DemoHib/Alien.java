package com.telusko.DemoHib;



//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;

//@Entity(name = "alien_table")

//  @Entity is used for this class is allowed to store its object in database
@Entity
@Table(name="alien_table")
public class Alien  
{
	@Id
	private int aid;
//	@Transient //we will not store aname in database 
	private AlienName aname;
	//	@Column(name = "alien_color") //Rename it in database table
	private String color;

	
	public int getAid() {
		return aid;
	}
	
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
//	public String getAname() {
//	return aname;
//}
//public void setAname(String aname) {
//	this.aname = aname;
//}

	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	

}
