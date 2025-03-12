package com.testtask.teststore

import com.testtask.teststore.utils.formatDate
import org.junit.Assert.assertEquals
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `formatDate should return correct formatted date`() {
        val timestamp = 1633046400000L // 01.10.2021
        val expectedDate = "01.10.2021"

        assertEquals(expectedDate, formatDate(timestamp))
    }
}
