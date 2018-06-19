
package org.mycontroller.standalone.db.dao;

import java.util.List;

import org.mycontroller.standalone.db.tables.CalendarSensors;


public interface CalendarSensorsDao extends BaseDao<CalendarSensors, Object> {

    List<CalendarSensors> getByCalendarId(Integer calendarId);

    //List<CalendarSensors> getBySensorId(Integer sensorId);

    void deleteByCalendarId(Integer calendarId);

    void deleteBySensorId(Integer sensorId);

    List<Integer> getSensorIdsByCalendarId(Integer calendarId);
}
