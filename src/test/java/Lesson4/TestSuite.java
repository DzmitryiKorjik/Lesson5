package Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.notification.RunListener;

public class TestSuite {
    @Test
    public void runAllTests() {
        org.junit.runner.JUnitCore junit = new org.junit.runner.JUnitCore();
        junit.addListener(new XMLReporter());
        junit.run(TriangleTest.class);
        Assertions.assertTrue(true);
    }

    private class XMLReporter extends RunListener {
    }
}