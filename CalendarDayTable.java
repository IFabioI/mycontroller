package org.mycontroller.standalone.db.tables;

import java.util.ArrayList;
import java.util.List;

import org.mycontroller.standalone.db.DB_TABLES;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@DatabaseTable(tableName = DB_TABLES.CALENDAR_DAY)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
public class CalendarDayTable {
    public static final String KEY_CALENDAR_ID = "calendarId";
    public static final String KEY_CALENDAR_DAY_ID = "calendarDayId";
    public static final String KEY_DAY = "day";
    public static final String KEY_MONTH = "month";
    public static final String KEY_YEAR = "year";

    @DatabaseField(canBeNull = false, columnName = KEY_CALENDAR_ID, uniqueCombo = true, foreign = true,
            foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 0)
    private Calendar calendar;
    
}
