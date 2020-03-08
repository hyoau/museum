package edu.nwu.museum.dao;

import edu.nwu.museum.domain.PermResource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface PermResourceMapper {

    List<PermResource> findAll();

    PermResource find(String permResId);

    void update(PermResource permResource);

    void delete(String permResId);

    void insert(PermResource permResource);
}
