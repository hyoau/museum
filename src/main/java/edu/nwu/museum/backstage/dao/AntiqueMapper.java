package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Antique;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AntiqueMapper {
  List<Antique> findAll();

  Antique findById(@Param("antiqueId") String antiqueId, @Param("seqNo") Integer seqNo);

  void insert(Antique antique);

  void update(Antique antique);

  int deleteById(@Param("antiqueId") String antiqueId, @Param("seqNo") Integer seqNo);
}
