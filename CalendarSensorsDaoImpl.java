package org.mycontroller.standalone.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mycontroller.standalone.db.tables.CalendarSensors;

import com.j256.ormlite.support.ConnectionSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarSensorsDaoImpl extends BaseAbstractDaoImpl<CalendarSensors, Object>
        implements CalendarSensorsDao {

    public CalendarSensorsDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, CalendarSensors.class);
    }

    @Override
    public CalendarSensors get(CalendarSensors tdao) {
        // not supported
        return null;
    }

    @Override
    public List<CalendarSensors> getAll(List<Object> ids) {
        // not supported
        return null;
    }

    @Override
    public List<CalendarSensors> getByCalendarId(Integer calendarId) {
        return super.getAll(CalendarSensors.KEY_CALENDAR_ID, calendarId);
    }

    @Override
    public List<CalendarSensors> getBySensorId(Integer sensorId) {
        return super.getAll(CalendarSensors.KEY_SENSOR_ID, sensorId);
    }

    @Override
    public void deleteBySensorId(Integer sensorId) {
        super.delete(CalendarSensors.KEY_SENSOR_ID, sensorId);
    }

    @Override
    public void deleteByCalendarId(Integer calendarId) {
        super.delete(CalendarSensors.KEY_CALENDAR_ID, calendarId);

    }
    
    //check

    @Override
    public List<Integer> getSensorIdsByCalendarId(Integer calendarId) {
        List<Integer> roleIds = new ArrayList<Integer>();
        try {
            if (calendarId != null) {
                List<CalendarSensors> calendarSensorsList = this.getDao().queryBuilder()
                        .where()
                        .eq(CalendarSensors.KEY_CALENDAR_ID, calendarId).query();
                for (CalendarSensors calendarSensors : calendarSensorsList) {
                    roleIds.add(calendarSensors.getSensor().getId());
                }
            }
        } catch (SQLException ex) {
            _logger.error("Exception, ", ex);
        }
        return roleIds;
    }

}
