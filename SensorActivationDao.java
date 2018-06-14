
package org.mycontroller.standalone.db.dao;

import java.util.List;

public interface SensorActivationDao extends BaseDao<SensorActivation, Object> {

    void deleteBySensorId(Integer sensorId);

    void deleteByCalendarDayId(Integer calendarDayId);

    List<String> getNamesByIds(Integer sensorId);
    
    List<List<Integer>> getDate(Integer sensorId);
}
