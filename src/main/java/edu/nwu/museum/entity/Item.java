package edu.nwu.museum.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import lombok.Data;

@Data
public class Item {
    String id;
    String title;
    String status;
    String author;
    Timestamp display_time;
    Integer pageViews;

    Item() {
        this.id = "123456";
        this.title = "In solitude where we are least alone.";
        this.status = "published";
        this.author = "Shirley Brown";
        this.display_time = new Timestamp(new Date().getTime());
        this.pageViews = new Random().nextInt(4700 + 1) + 300;
    }
}
