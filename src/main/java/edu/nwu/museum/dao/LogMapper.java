package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Log;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {
  List<Log> findAll();

  Log find(int logSeqNo);

  void update(Log log);

  void delete(int logSeqNo);

  void insert(Log log);
}
