package org.mycontroller.standalone.db.dao;

import java.sql.SQLException;
import java.util.List;

import org.mycontroller.standalone.api.jaxrs.model.Query;
import org.mycontroller.standalone.api.jaxrs.model.QueryResponse;
import org.mycontroller.standalone.db.tables.RuleDefinitionTable;
import org.mycontroller.standalone.db.tables.Timer;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarDaoImpl extends BaseAbstractDaoImpl<Calendar, Integer> implements CalendarDao {
    public CalendarDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Timer.class);
    }

    @Override
    public QueryResponse getAll(Query query) {
        try {
            query.setIdColumn(Calendar.KEY_ID);
            return this.getQueryResponse(query);
        } catch (SQLException ex) {
            _logger.error("unable to run query:[{}]", query, ex);
            return null;
        }
    }

    @Override
    public List<Calendar> getAll(List<Integer> ids) {
        return getAll(Calendar.KEY_ID, ids);
    }

    @Override
    public Calendar get(Calendar calendar) {
        return super.getById(calendar.getId());
    }

}
