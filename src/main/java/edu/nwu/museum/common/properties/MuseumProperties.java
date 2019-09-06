package edu.nwu.museum.common.properties;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class MuseumProperties {
  private ShiroProperties shiro = new ShiroProperties();

  private boolean openAopLog = true;
}
