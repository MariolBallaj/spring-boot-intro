package com.lhind.internship.springboot.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonUtilsTest {

    @Test
    void testAddNumbersWith1And2ShouldReturn3() {
        Assertions.assertEquals(3, CommonUtils.add(1, 2));
    }

}