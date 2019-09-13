package edu.nwu.museum.service;

import edu.nwu.museum.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SysLogService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * Use Spring JdbcTemplate to save log.
   * @param sysLog
   */
  public void saveSysLog(SysLog sysLog) {
    StringBuffer sql = new StringBuffer(" insert into t_sys_log ");
    sql.append(" (id, user_id, operation, time, method, params, ip, create_time) ");
    sql.append(" values(0, :userId, :operation, :time, :method, :params, :ip, :create_time) ");

    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
    namedParameterJdbcTemplate.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
  }
}
