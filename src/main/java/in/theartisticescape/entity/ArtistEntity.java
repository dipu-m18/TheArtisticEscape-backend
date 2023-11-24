package in.theartisticescape.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ARTIST_DB")
public class ArtistEntity {
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PASSWORD")
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ARTIST_EMAIL_ID")
	private List<ArtEntity> listOfArts;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ArtEntity> getListOfArts() {
		return listOfArts;
	}

	public void setListOfArts(List<ArtEntity> listOfArts) {
		this.listOfArts = listOfArts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
