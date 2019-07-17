package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Log;
import java.util.List;

public interface LogMapper {
  List<Log> findAll();

  Log find(int logSeqNo);

  void update(Log log);

  void delete(int logSeqNo);

  void insert(Log log);
}
