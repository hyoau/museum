package edu.nwu.museum.dao;


import edu.nwu.museum.domain.Favourite;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteMapper {

  List<Favourite> findAll();

  Favourite find(Integer seqNo);

  void update(Favourite favourite);

  void delete(Integer seqNo);

  void insert(Favourite favourite);
}
