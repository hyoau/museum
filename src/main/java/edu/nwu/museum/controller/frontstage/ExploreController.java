package edu.nwu.museum.controller.frontstage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/explore")
public class ExploreController {
    @RequestMapping("/category-list")
    public String listCategory() {
        log.info("分类浏览");
        return "分类浏览";
    }

    @RequestMapping("/this-week-theme")
    public String thisWeekTheme() {
        log.info("本周主题");
        return "本周主题";
    }

    @RequestMapping("/popular-topic")
    public String popularTopic() {
        log.info("热门主题");
        return "热门主题";
    }
}
