
package org.mycontroller.standalone.db.dao;

import java.util.List;

import org.mycontroller.standalone.db.tables.CalendarDay;


public interface CalendarDayDao extends BaseDao<CalendarDay, Object> {

   // List<Sensor> getByCalendarId(Integer calendarId);

  //  List<OperationTimerMap> getByDayId(Integer calendarDayId);

    void deleteByCalendarId(Integer calendarId);

    void deleteByCalendarDayId(Integer day, Integer month, Integer year);

    List<Integer> getCalendarDayIdsByCalendarId(Integer calendarDayId);
}
