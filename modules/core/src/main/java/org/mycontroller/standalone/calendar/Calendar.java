import java.util.HashMap;
import java.util.List;
import java.util.Date;

public class Calendar {

	private HashMap<String,CalendarDay> daysMap = new HashMap<String,CalendarDay>();
	private LinkedList<Sensor> sensors = new LinkedList<Sensor>();
	
	private String name;
	
	Calendar(String name){
		this.name = name;
	}


	public CalendarDay getDay(String day) {
		return daysMap.get(day);
	}

	public void createDay(String day, CalendarDay calendarday) {
		if(daysMap.get(day) == null)
			daysMap.put(day,calendarday);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);
	}

	public void removeSensor(int index) {
		this.sensors.remove(index);
	}
	
	public Sensor getSensor(int index)
	{
		return sensors.get(index);
	}
	
	public bool checkSensors(Sensor sensor)
	{
		int index;
		for(index = 0 ; index < sensors.size() ; index++)
		{
			if(sensors[index] == sensor)
				return true;
		}
		return false;
	}

}
