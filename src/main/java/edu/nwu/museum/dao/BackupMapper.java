package edu.nwu.museum.dao;


import edu.nwu.museum.domain.Backup;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BackupMapper {

  List<Backup> findAll();

  Backup findById(Integer seqNo);

  void insert(Backup backup);

  void update(Backup backup);

  int deleteById(Integer seqNo);
}
