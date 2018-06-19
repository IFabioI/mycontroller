package org.mycontroller.standalone.db.tables;

import java.util.ArrayList;
import java.util.List;

import org.mycontroller.standalone.db.DB_TABLES;
import org.mycontroller.standalone.db.DaoUtils;
import org.mycontroller.standalone.operation.OperationUtils;
import org.mycontroller.standalone.operation.model.Operation;
import org.mycontroller.standalone.timer.TimerUtils;
import org.mycontroller.standalone.timer.TimerUtils.FREQUENCY_TYPE;
import org.mycontroller.standalone.timer.TimerUtils.TIMER_TYPE;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@DatabaseTable(tableName = DB_TABLES.SENSOR_ACTIVATION)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
public class SensorActivationTable {
    public static final String KEY_SENSOR_ID = "sensorId";
    public static final String KEY_CALENDAR_DAY_ID = "calendarDayId";
    public static final String KEY_SENSOR_NAME = "sensorName";

    @DatabaseField(canBeNull = false, columnName = KEY_CALENDAR_DAY_ID, uniqueCombo = true, foreign = true,
            foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 0)
    private CalendarDay calendarDay;
    
    @DatabaseField(canBeNull = false, columnName = KEY_SENSOR_ID, uniqueCombo = true, foreign = true,
            foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 0)
    private Sensor sensor;

  //  private String targetClass;

    private List<String> sensorNames;
    private List<List<Integer>> sensorDate;
/*
    @JsonIgnore
    private List<Sensor> sensors;*/

    public List<String> getSensorNames() {
        if (sensorNames == null) {
            if (id != null) {
            	sensorNames = DaoUtils.getSensorActivationDao().getNamesByIds(getId());
            } else {
            	sensorNames = new ArrayList<String>();
            }
        }
        return sensorNames;
    }
    
    public List<Integer> getDate() {
        if (sensorDate == null) {
            if (id != null) {
            	sensorDate = DaoUtils.getSensorActivationDao().getDate(getId());
            } else {
            	sensorDate = new ArrayList<ArrayList<Integer>>();
            }
        }
        return sensorDate;
    }
}
