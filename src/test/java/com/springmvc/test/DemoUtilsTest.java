package com.springmvc.test;

import com.springmvc.DemoUtils;
import com.springmvc.SupportHelp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = DemoUtils.class)
class DemoUtilsTest
{
    @InjectMocks
    DemoUtils demoUtils;

    @MockBean
    SupportHelp supportHelp;

    @BeforeEach
    void setUp()
    {
        System.out.println("Before each.");
    }
    @Test
    @DisplayName("Test 1")
    void testEqualsAndNotEquals()
    {
        System.out.println(demoUtils.add(1,2));
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("After each.");
    }
}
