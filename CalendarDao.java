package org.mycontroller.standalone.db.dao;

import java.util.List;

import org.mycontroller.standalone.api.jaxrs.model.Query;
import org.mycontroller.standalone.api.jaxrs.model.QueryResponse;
import org.mycontroller.standalone.db.tables.Timer;


public interface CalendarDao extends BaseDao<Calendar, Integer> {

  //  List<Timer> getAllEnabled();

  //  Calendar getByName(String name);

    QueryResponse getAll(Query query);
   

}
