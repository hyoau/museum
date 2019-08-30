package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Template;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateMapper {
  List<Template> findAll();

  Template find(String templateId);

  void insert(Template template);

  void delete(String templateId);

  void update(Template template);
}
