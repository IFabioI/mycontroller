package org.mycontroller.standalone.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mycontroller.standalone.db.tables.SensorActivation;

import com.j256.ormlite.support.ConnectionSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SensorActivationDaoImpl extends BaseAbstractDaoImpl<CalendarDay, Object>
        implements SensorActivationDao {

    public SensorActivationDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SensorActivation.class);
    }

    @Override
    public SensorActivation get(SensorActivation tdao) {
        // not supported
        return null;
    }

    @Override
    public List<SensorActivation> getAll(List<Object> ids) {
        // not supported
        return null;
    }

    @Override
    public void deleteBySensorId(Integer sensorId) {
        super.delete(SensorActivation.KEY_SENSOR_ID, sensorId);
    }

    @Override
    public void deleteByCalendarDayId(Integer calendarDayId) {
        super.delete(CalendarDay.KEY_CALENDAR_DAY_ID, calendarDayId);

    }
    
    @Override    
    public List<List<Integer>> getDate (Integer sensorId) {
    	

    }
    
   
    List<List<Integer>> getDate(Integer sensorId);
    
    //check

    @Override
    public List<String> getNamesByIds(Integer sensorId) {
        List<String> roleIds = new ArrayList<String>();
        try {
            if (calendarId != null) {
                List<Sensor> sensorList = this.getDao().queryBuilder()
                        .where()
                        .eq(Sensor.KEY_SENSOR_ID, sensorId).query();
                for (Sensor sensor : sensorList) {
                    roleIds.add(Sensor.getName());
                }
            }
        } catch (SQLException ex) {
            _logger.error("Exception, ", ex);
        }
        return roleIds;
    }

}
