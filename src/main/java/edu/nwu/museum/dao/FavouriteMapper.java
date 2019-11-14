package edu.nwu.museum.dao;


import edu.nwu.museum.domain.Favourite;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface FavouriteMapper {

  List<Favourite> findAll();

  Favourite find(Integer seqNo);

  void update(Favourite favourite);

  void delete(Integer seqNo);

  void insert(Favourite favourite);
}
