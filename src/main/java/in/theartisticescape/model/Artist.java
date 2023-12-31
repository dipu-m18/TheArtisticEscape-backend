package in.theartisticescape.model;

import java.util.List;


public class Artist {
	private String emailId;
	private String name;
	private String password;
	private List<Art> listOfArts;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Art> getListOfArts() {
		return listOfArts;
	}
	public void setListOfArts(List<Art> listOfArts) {
		this.listOfArts = listOfArts;
	}
	
	
}
