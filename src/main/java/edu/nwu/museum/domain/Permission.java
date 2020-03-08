package edu.nwu.museum.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String url;
    private String name;
}