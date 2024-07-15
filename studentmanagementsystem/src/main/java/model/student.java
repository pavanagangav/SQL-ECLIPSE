package model;

public class student {
private String rollnumber;
private String Name;
private String Email;
private String Branch;
private String Sectio;
public String getRollnumber() {
	return rollnumber;
}
public void setRollnumber(String rollnumber) {
	this.rollnumber = rollnumber;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getBranch() {
	return Branch;
}
public void setBranch(String branch) {
	Branch = branch;
}
public String getSectio() {
	return Sectio;
}
public void setSectio(String sectio) {
	Sectio = sectio;
}
public student() {
	super();
	// TODO Auto-generated constructor stub
}
public student(String rollnumber, String name, String email, String branch, String sectio) {
	super();
	this.rollnumber = rollnumber;
	Name = name;
	Email = email;
	Branch = branch;
	Sectio = sectio;
}


}
