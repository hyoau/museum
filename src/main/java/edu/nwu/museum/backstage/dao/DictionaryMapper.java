package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Dictionary;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryMapper {
  List<Dictionary> findAll();

  Dictionary findById(@Param("dictCode") String dictCode, @Param("dictItemCode") int dictItemCode);

  void update(Dictionary dictionary);

  void insert(Dictionary dictionary);

  int deleteById(@Param("dictCode") String dictCode, @Param("dictItemCode") Integer dictItemCode);
}
