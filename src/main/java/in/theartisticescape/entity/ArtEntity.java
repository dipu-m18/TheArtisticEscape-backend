package in.theartisticescape.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="ART_DB")
public class ArtEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="artist_email_id")
	private String artistEmailId;
	@Column(name="date_time")
	private LocalDateTime dateTime;
	@Column(name="place")
	private String place;
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_type")
	private String fileType;
	@Lob
	private byte art_image[];
	
	
	public byte[] getArt_image() {
		return art_image;
	}
	public String getArtistEmailId() {
		return artistEmailId;
	}
	public void setArtistEmailId(String artistEmailId) {
		this.artistEmailId = artistEmailId;
	}
	public void setArt_image(byte[] art_image) {
		this.art_image = art_image;
	}
	public String getEmail_id() {
		return artistEmailId;
	}
	public void setEmail_id(String email_id) {
		this.artistEmailId = email_id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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


	
	
}
