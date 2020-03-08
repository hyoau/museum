package edu.nwu.museum.service;

import edu.nwu.museum.dao.NewsMapper;
import edu.nwu.museum.domain.News;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    public List<News> findAll() {
        return newsMapper.findAll();
    }

    public News findById(String newsId) {
        return newsMapper.findById(newsId);
    }

    public void update(News news) {
        newsMapper.update(news);
    }

    public void insert(News news) {
        newsMapper.insert(news);
    }

    public void deleteById(String newsId) {
        newsMapper.deleteById(newsId);
    }

    public List<News> paginate(Integer offset) {
        return newsMapper.paginate(offset * 10);
    }
}
