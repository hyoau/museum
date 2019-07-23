package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Antique;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface AntiqueMapper {
  List<Antique> findAll();

  Antique findById(String antiqueId, Integer seqNo);

  void insert(Antique antique);

  void update(Antique antique);

  void deleteById(String antiqueId);
}
