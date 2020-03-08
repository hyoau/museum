package edu.nwu.museum.dao;

import edu.nwu.museum.domain.News;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface NewsMapper {
    List<News> findAll();

    News findById(String newsId);

    void update(News news);

    void insert(News news);

    int deleteById(String newsId);

    List<News> paginate(Integer offset);
}
