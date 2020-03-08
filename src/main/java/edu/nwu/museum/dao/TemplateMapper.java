package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Template;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface TemplateMapper {
    List<Template> findAll();

    Template find(String templateId);

    void insert(Template template);

    void delete(String templateId);

    void update(Template template);
}
