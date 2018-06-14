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

@DatabaseTable(tableName = DB_TABLES.CALENDAR)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
public class CalendarTable {
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true, columnName = KEY_ID)
    private Integer id;

    @DatabaseField(canBeNull = false, uniqueCombo = true, columnName = KEY_NAME)
    private String name;

  //  private String targetClass;

    private List<Integer> sensorIds, calendarDayIds;
/*
    @JsonIgnore
    private List<Sensor> sensors;*/

    public List<Integer> getSensorIds() {
        if (sensorIds == null) {
            if (id != null) {
            	sensorIds = DaoUtils.getCalendarSensorsDao().getSensorIdsByCalendarId(getId());
            } else {
            	sensorIds = new ArrayList<Integer>();
            }
        }
        return sensorIds;
    }
    
    public List<Integer> getCalendarDayIds() {
        if (calendarDayIds == null) {
            if (id != null) {
            	calendarDayIds = DaoUtils.getCalendarDayDao().getCalendarDayIdsByCalendarId(getId());
            } else {
            	calendarDayIds = new ArrayList<Integer>();
            }
        }
        return calendarDayIds;
    }

 /*   @JsonIgnore
    public List<Operation> getSensors() {
        if (sensors == null) {
            sensors = new ArrayList<Sensor>();
            List<OperationTable> OperationsInDb = DaoUtils.getOperationDao().getByTimerId(getId());
            for (OperationTable operationTable : OperationsInDb) {
                Operation operationModel = OperationUtils.getOperation(operationTable);
                if (operationModel != null) {
                    operations.add(operationModel);
                }
            }
        }
        return operations;
    }

    @JsonGetter("operations")
    private List<String> getOperationsList() {
        List<String> operations = new ArrayList<String>();
        for (Operation operation : getOperations()) {
            operations.add(operation.getName());
        }
        return operations;
    }

    public String getTimerDataString() {
        try {
            return TimerUtils.getTimerDataString(this);
        } catch (Exception ex) {
            return "Error: " + ex.getMessage();
        }
    }

    public String getValidityString() {
        return TimerUtils.getValidityString(this);
    }

    public void setFrequencyData(String frequencyData) {
        if (frequencyData != null && frequencyData.length() > 0) {
            this.frequencyData = frequencyData;
        }
    }*/

}
