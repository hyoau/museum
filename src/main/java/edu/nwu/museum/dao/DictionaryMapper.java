package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Dictionary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface DictionaryMapper {
    List<Dictionary> findAll();

    Dictionary findById(@Param("dictCode") String dictCode, @Param("dictItemCode") int dictItemCode);

    void update(Dictionary dictionary);

    void insert(Dictionary dictionary);

    int deleteById(@Param("dictCode") String dictCode, @Param("dictItemCode") Integer dictItemCode);
}
