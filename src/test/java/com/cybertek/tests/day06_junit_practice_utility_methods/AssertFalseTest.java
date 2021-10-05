package com.cybertek.tests.day06_junit_practice_utility_methods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertFalseTest {

        @Test
        public void testNum() {

            int num = 10;

            // write assertion to check if num is more than 9
            assertTrue(num>9);

            // write assertion to check if num is less than 5
            assertTrue(!(num<5));

            assertFalse(num<5); // this is the way

        }
    }