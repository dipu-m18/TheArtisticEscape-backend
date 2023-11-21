package in.theartisticescape.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="ART_DB")
public class ArtEntity {
	@Id
	private Integer id;
	@Column(name="artist_email_id")
	private String emailId;
	@Column(name="date_time")
	private LocalDateTime dateTime;
	@Column(name="place")
	private String place;
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_type")
	private String fileType;
	@Lob
	private byte[] art_image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail_id() {
		return emailId;
	}
	public void setEmail_id(String email_id) {
		this.emailId = email_id;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public byte[] getArt_image() {
		return art_image;
	}
	public void setArt_image(byte[] art_image) {
		this.art_image = art_image;
	}
	
	
}
