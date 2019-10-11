package edu.nwu.museum.service;

import edu.nwu.museum.dao.AntiqueMapper;
import edu.nwu.museum.domain.Antique;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AntiqueService {
  @Autowired
  AntiqueMapper antiqueMapper;

  List<Antique> findAll() {
    return antiqueMapper.findAll();
  }

  Antique findById(String antiqueId, Integer seqNo) {
    return antiqueMapper.findById(antiqueId, seqNo);
  }

  void insert(Antique antique) {
    antiqueMapper.insert(antique);
  }

  void update(Antique antique) {
    antiqueMapper.update(antique);
  }

  void deleteById(String antiqueId, Integer seqNo) {
    antiqueMapper.deleteById(antiqueId, seqNo);
  }

  public List<Antique> paginate(Integer offset) {
    return antiqueMapper.paginate(offset*10);
  }
}
