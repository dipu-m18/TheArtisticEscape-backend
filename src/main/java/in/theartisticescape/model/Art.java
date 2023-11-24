package in.theartisticescape.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Art {
	
	private String artistEmailId;
	private LocalDateTime dateTime;
	private String place;
	private String fileName;
	private String fileType;
	//private ArrayList<Byte> data;
	private byte[] data;
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getArtistEmailId() {
		return artistEmailId;
	}
	public void setArtistEmailId(String artistEmailId) {
		this.artistEmailId = artistEmailId;
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
//	public ArrayList<Byte> getData() {
//		return data;
//	}
//	public void setData(ArrayList<Byte> data) {
//		this.data = data;
//	}

	
}
