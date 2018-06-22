package org.mycontroller.standalone.actor;

import java.util.Scanner;
import org.mycontroller.standalone.calendar.BaseCalendar;

public class Actor {
	static BaseCalendar baseCalendar;
	private static Scanner sc;
	private static Scanner sc2;
	
	private static LinkedList<String> messages = new LinkedList<String>;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		Date currenttime = new Date();
		
		String usrInput;
		
		do {
			usrInput = sc.next();
			
			String[] inputTokens = usrInput.split(" ");
			
			switch(inputTokens[0]) {
				case "createCalendar":
					baseCalendar.request(usrInput);
					String response = Listen();
					String id = response.split(" ")[0];
					String name = response.split(" ")[1];
					System.out.println("new calendar created, id: " + id = ", name: " + name);
					break;
				case "removeCalendar":
					String name = inputTokens[1];
					if(areYouSure(name))
						//name
						baseCalendar.request(usrInput);
					System.out.println("calendar " + name + " removed");
					break;
				case "editCalendarName":
					//old name and new name
					
					baseCalendar.request(usrInput);
					System.out.println("calendar " + inputTokens[1] + " changed to " + inputTokens[2]);
					break;
				case "openCalendar":
					//name
					baseCalendar.request(usrInput);
					System.out.println("calendar " + inputTokens[1] + " opened");
					break;
				case "openCalendarDay":
					//day
					baseCalendar.request("" + (currenttime.getYear() + 1900) + current.time.getMonth + inputTokens[1]);
					int activationSize = Integer.parseInt(Listen());
					for(int i = 0; i < activationSize; i++)
					{
						String response = Listen();
						String sensorname = response.split(" ")[0];
						Date time = new Date(Long.parseLong(response.split(" ")[1]));
						System.out.println("sensor " + sensorname + " activated on " + time.getDate() + "/" + time.getMonth() + "/" + (time.getYear() + 1900) + " " + time.getHours() + ":" + time.getMinutes + ":" + time.getSeconds + " id: " + i);
					}
					break;
				case "help":
					showOptions();
					break;
			}
		}while(usrInput != "exit");
	}
	
	public void eventOperation(String event) {
		switch(event) {
			case "removeEvent":
				break;
			case "addSensor":
				break;
			case "deleteSensor":
				break;
		}
	}
	
	private static void showOptions() {
		System.out.println("Options:");
		System.out.println("createCalendar - creates new calendar");
		System.out.println("removeCalendar [name] - removes calendar of name "
				+ "[name]");
		System.out.println("editCalendarName [old name] [new name] - replaces a "
				+ "calendar's old name with a new name");
		System.out.println("openCalendar [name] - opens calendar of name [name]");
		System.out.println("openCalendarDay [day] - opens visualization of "
				+ "a specific day [day]");
		System.out.println("exit - exit system");
	}
	
	private static boolean areYouSure(String name) {
		sc2 = new Scanner(System.in);
		String usrInput;
		while(true) {
			System.out.println("Are you sure you want to remove calendar "+name+"? y/n");
			usrInput = sc2.next();
			if(usrInput == "y") return true;
			else if (usrInput == "n") return false;
		}
	}
	
	private static String listen()
	{
		while(messages.size() == 0);
		String ret = messages.getFirst();
		messages.removeFirst();
		return ret;
	}
	
	public static void sendMessage(String message)
	{
		messages.push(message);
	}
}
