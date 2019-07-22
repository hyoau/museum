package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Museum;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumMapper {
  List<Museum> findAll();

  Museum find(String museumId);

  void update(Museum museum);

  void delete(String museumId);

  void insert(Museum museum);
}
