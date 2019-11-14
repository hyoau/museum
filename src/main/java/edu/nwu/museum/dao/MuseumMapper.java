package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Museum;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MuseumMapper {
  List<Museum> findAll();

  Museum find(String museumId);

  void update(Museum museum);

  void delete(String museumId);

  void insert(Museum museum);
}
