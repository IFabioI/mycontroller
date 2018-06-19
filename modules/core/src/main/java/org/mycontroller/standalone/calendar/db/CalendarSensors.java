package org.mycontroller.standalone.db.tables;

import org.mycontroller.standalone.db.DB_TABLES;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@DatabaseTable(tableName = DB_TABLES.CALENDAR_SENSORS)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
public class CalendarSensors {
    public static final String KEY_SENSOR_ID = "sensorId";
    public static final String KEY_CALENDAR_ID = "calendarId";

    @DatabaseField(canBeNull = false, columnName = KEY_CALENDAR_ID, uniqueCombo = true, foreign = true,
            foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 0)
    private CalendarTable calendar;

    @DatabaseField(canBeNull = false, columnName = KEY_SENSOR_ID, uniqueCombo = true, foreign = true,
            foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 0)
    private Sensor sensor;
}