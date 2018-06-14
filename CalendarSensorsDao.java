
package org.mycontroller.standalone.db.dao;

import java.util.List;

import org.mycontroller.standalone.db.tables.CalendarSensors;


public interface CalendarSensorsDao extends BaseDao<CalendarSensors, Object> {

    List<OperationTimerMap> getByCalendarId(Integer calendarId);

    List<OperationTimerMap> getBySensorId(Integer sensorId);

    void deleteByCalendarId(Integer calendarId);

    void deleteBySensorId(Integer sensorId);

    List<Integer> getSensorIdsByCalendarId(Integer calendarId);
}
