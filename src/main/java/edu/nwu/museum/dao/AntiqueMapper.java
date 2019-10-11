package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Antique;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AntiqueMapper {
  List<Antique> findAll();

  Antique findById(String antiqueId, Integer seqNo);

  void insert(Antique antique);

  void update(Antique antique);

  int deleteById(String antiqueId, Integer seqNo);

  List<Antique> paginate(Integer offset);
}
