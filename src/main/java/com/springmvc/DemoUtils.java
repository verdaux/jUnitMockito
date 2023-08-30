package com.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class DemoUtils
{
    @Autowired
    SupportHelp supportHelp;
    public int add(int a, int b)
    {
        return a + b;
    }
}
