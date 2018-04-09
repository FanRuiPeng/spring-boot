package com.bmf.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mongodb.morphia.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
//        assertTrue( true );
        Employee employee = Employee.builder().name("张三")
                .salary(1.0)
                .directReports(new ArrayList<>()).build();
        List<Employee> directReports = employee.getDirectReports();
        directReports.add(new Employee());
        System.out.println(employee);
        System.out.println(directReports);
    }
}
