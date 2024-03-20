package com.springmvc.test;

import com.springmvc.configs.UtilConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = UtilConfig.class, initializers = PropertyMockApplCtxInitializer.class)
@TestPropertySource(locations = { "classpath:utils.yml"})
public class TestPropertyValuesFromConfig
{
    /*@InjectMocks
    UtilConfig util;*/

    private AutoCloseable closeable;

    @Value("${testing.test}")
    private String test;
    @BeforeEach
    public void setUp() throws Exception
    {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void sampleTest()
    {
        System.out.println("value of test is:: "+test);
        Assertions.assertEquals("sample value",test);
    }

    @AfterEach
    public void tearDown() throws Exception
    {
        closeable.close();
    }
}
