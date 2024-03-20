package com.springmvc.test;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockPropertySource;

public class PropertyMockApplCtxInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>
{
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
        MockPropertySource mockEnvVars = new MockPropertySource();
        propertySources.replace(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, mockEnvVars);
    }
}
