package edu.nwu.museum.controller.admin;

import edu.nwu.museum.domain.Response;
import edu.nwu.museum.domain.News;
import edu.nwu.museum.service.NewsService;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
  @Autowired
  NewsService newsService;

  @CrossOrigin
  @RequestMapping("/api/news/list")
  public Response getNewsList(@RequestParam Integer offset) {
    ArrayList<News> newsList = new ArrayList<>(newsService.paginate(offset));
    HashMap<String, Object> data = new HashMap<>();
    for (News news: newsList) {
      data.put("newsList", newsList);
    }
    return new Response(20000, "SUCCESS", data);
  }
}
