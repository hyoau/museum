package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.PermResource;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PermResourceMapper {

  List<PermResource> findAll();

  PermResource find(String permResId);

  void update(PermResource permResource);

  void delete(String permResId);

  void insert(PermResource permResource);
}
