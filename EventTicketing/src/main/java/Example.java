import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Example {
	
private List<Datum> data;
	
	public List<Datum> getData() {
		return data;
	}
	public int getSize() {
		return data.size();
	}
	
	public void setData(List<Datum> data) {
		this.data = data;
	}
	
//	public boolean formatted() {
//		for(int i = 0; i < data.size(); i++) {
//			Datum event = data.get(i);
//			if(event.getName()==null || event.getTour()==null || event.getLocalDate()==null || event.getAgents()==null || event.getVenue()==null){
//				return false;
//			}
//		}
//		return true;
//	}
//	
	public Datum getDatabyIndex(int index){
		Datum event = data.get(index);
		return event;
	}
	
		
	
	
}
