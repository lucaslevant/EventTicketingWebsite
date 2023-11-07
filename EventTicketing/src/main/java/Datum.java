import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
	private String name;
	private String localDate;
	private String venue;
	private String eventid;
	private String image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLocalDate() {
		return localDate;
	}
	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}


	

}
//use to build another event



