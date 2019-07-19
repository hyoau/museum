package edu.nwu.museum.backstage.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Role implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String name;
  private String memo;
}
