package com.springmvc.configs;

import com.springmvc.utils.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@ConfigurationProperties(prefix = "utils")
@PropertySource(value = "classpath:utils.yml", factory = YamlPropertySourceFactory.class)
public class UtilConfig
{
    private String test;

    public UtilConfig()
    {}
    public UtilConfig(String test)
    {
        this.test = test;
    }

    public String getTest()
    {
        return test;
    }

    public void setTest(String test)
    {
        this.test = test;
    }

    @Bean(name = "utilPlaceHolder")
    static PropertySourcesPlaceholderConfigurer valuePropertyConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();

    }
}
