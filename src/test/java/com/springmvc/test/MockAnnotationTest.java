package com.springmvc.test;

import com.springmvc.MvcTestingExampleApplication;
import com.springmvc.dao.ApplicationDao;
import com.springmvc.models.CollegeStudent;
import com.springmvc.models.StudentGrades;
import com.springmvc.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest
{
    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    // @Mock
    @MockBean
    private ApplicationDao applicationDao;

    // @InjectMocks
    @Autowired
    private ApplicationService applicationService;

    @BeforeEach
    public void beforeEach() {
        studentOne.setFirstname("Eric");
        studentOne.setLastname("Roby");
        studentOne.setEmailAddress("eric.roby@luv2code_school.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & Verify")
    @Test
    public void assertEqualsTestAddGrades()
    {
        when(applicationDao.addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults())).thenReturn(100.00);

        assertEquals(100, applicationService.addGradeResultsForSingleClass(
                studentOne.getStudentGrades().getMathGradeResults()));

        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao, times(1)).addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults());
    }
}
