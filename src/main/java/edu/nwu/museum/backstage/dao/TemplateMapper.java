package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Template;
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
