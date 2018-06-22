package org.mycontroller.standalone.calendar;

import java.util.LinkedList;
import java.util.List;

import org.mycontroller.standalone.db.tables.Timer;

public class BaseCalendar {

	private static LinkedList<Calendar> calendars;
	
	private static int calendarIndex;
	private static Calendar calendar;
	private static CalendarDay day;
	private static Actor;
	
	BaseCalendar(Actor actor)
	{
		this.actor = actor;
	}

	public static int request(String request) {
		String[] tokens = request.split(" ");
		switch(tokens[0])
		{
			case "newCalendar":
				int index = calendars.size();
				addCalendar(new Calendar(Integer.toString(index)));
				actor.sendMessage("" + index);
				break;
			case "openCalendar":
				if(!getIndexByName(tokens[1]))
					System.out.println("Calendar does not exist!");
				else
					calendar = calendars.get(calendarIndex);
				break;
			case "deleteCalendar":
				if(!getIndexByName(tokens[1]))
					System.out.println("Calendar does not exist!");
				else
					removeCalendar(calendarIndex);
				break;
			case "editCalendarName":
				if(!getIndexByName(tokens[1]))
					System.out.println("Calendar does not exist!");
				else
					calendar.setName(tokens[2]);
				break;
			case "addSensor":
				int index1 = Integer.parseInt(tokens[1]);
				//get sensor from index
				calendar.addSensor(sensor);
				break;
			case "deleteSensor":
				int index1 = Integer.parseInt(tokens[1]);
				calendar.removeSensor(index1);
				break;
			case "deleteActivation":
				int index1 = Integer.parseInt(tokens[1]);
				day.removeActivation(index1);
				break;
			case "openCalendarDay":
				//arrumar
				day = calendar.getDay(token[1]);
				int activationSize = day.getActivationAmount();
				actor.sendMessage("" + activationSize);
				for(int i = 0; i < activationSize; i++)
				{
					SensorActivation activation = day.getActivation(i);
					actor.sendMessage(activation.getSensorName() + " " + activation.getActivationTime().getTime());
				}
				break;
		}
		return 0;
	}
	
	private static boolean getIndexByName(String name) {
		for(int index=0;index < calendars.size();index++) {
			if(calendars[index].getName() == tokens[1]) {
				this.calendarIndex = index;
				return true;
			}
		}
		return false;
	}

	public static void addCalendar(Calendar cal) {
		calendars.add(cal);
	}

	public static void removeCalendar(int index) {
		calendars.remove(index);
	}

	public static void onSensorActivate(Sensor sensor, long milis) {
		int index;
		for(index = 0 ; index < calendars.size(); index++)
		{
			if(calendars[index].checkSensors(sensor))
				System.out.println("Sensor " + sensor.KEY_NAME + " activated on time " + milis);
		}
	}

}
