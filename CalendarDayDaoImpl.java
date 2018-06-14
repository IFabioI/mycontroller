package org.mycontroller.standalone.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mycontroller.standalone.db.tables.CalendarDay;

import com.j256.ormlite.support.ConnectionSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarDayDaoImpl extends BaseAbstractDaoImpl<CalendarDay, Object>
        implements CalendarDayDao {

    public CalendarDayDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, CalendarDay.class);
    }

    @Override
    public CalendarDay get(CalendarDay tdao) {
        // not supported
        return null;
    }

    @Override
    public List<CalendarDay> getAll(List<Object> ids) {
        // not supported
        return null;
    }

  //  @Override
   // public List<CalendarDay> getByCalendarId(Integer calendarId) {
        return super.getAll(CalendarDay.KEY_CALENDAR_ID, calendarId);
   // }

   // @Override
   // public List<CalendarDay> getByDayId(Integer calendarDayId) {
    //    return super.getAll(CalendarDay.KEY_CALENDAR_DAY_ID, calendarDayId);
    //}

    @Override
    public void deleteByCalendarDayId(Integer calendarDayId) {
        super.delete(CalendarDay.KEY_CALENDAR_DAY_ID, calendarDayId);
    }

    @Override
    public void deleteByCalendarId(Integer calendarId) {
        super.delete(CalendarDay.KEY_CALENDAR_ID, calendarId);

    }
    
    //check

    @Override
    public List<Integer> getCalendarDayIdsByCalendarId(Integer calendarId) {
        List<Integer> roleIds = new ArrayList<Integer>();
        try {
            if (calendarId != null) {
                List<CalendarDay> calendarDayList = this.getDao().queryBuilder()
                        .where()
                        .eq(CalendarDay.KEY_CALENDAR_ID, calendarId).query();
                for (CalendarDay calendarDay : calendarDayList) {
                    roleIds.add(calendarDay.getCalendarDay().getId());
                }
            }
        } catch (SQLException ex) {
            _logger.error("Exception, ", ex);
        }
        return roleIds;
    }

}
