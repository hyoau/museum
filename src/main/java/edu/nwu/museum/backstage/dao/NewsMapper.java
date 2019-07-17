package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.News;
import java.util.List;


public interface NewsMapper {

  //根据ID查询所有资讯信息
  List<News> findAll();
  //根据ID查询资讯信息
  News findByNewsId(String newsId);
  //根据ID修改资讯信息
  int update(News news);
  //根据ID增加资讯信息
  int insert(News news);
  //根据ID删除资讯信息
  int deleteByNewsId(String newsId);
}
