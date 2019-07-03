package edu.nwu.museum.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "common")
public class CommonProperties {

  private ShiroProperties shiro = new ShiroProperties();

  private boolean openAopLog = true;

}
