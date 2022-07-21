package com.demo.virginmoneydemo.models

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

class PeopleTest {

    private lateinit var people: People

    @Before
    fun setUp() {
        people = People(
            "https://randomuser.me/api/portraits/women/21.jpg",
            "2022-01-24T17:02:23.729Z",
            "Nicolas61@hotmail.com",
            "pink",
            "Maggie",
            "1",
            "Future Functionality Strategist",
            "Brekke"
        )
    }

    @Test
    fun test_default_values() {
        assertEquals("1", people.id)
        assertEquals("Maggie Brekke", people.fullName)
        assertEquals("https://randomuser.me/api/portraits/women/21.jpg", people.avatar)
        assertEquals("Nicolas61@hotmail.com", people.email)
        assertEquals("pink", people.favouriteColor)
        assertEquals("Future Functionality Strategist", people.jobtitle)
        assertEquals("2022-01-24T17:02:23.729Z", people.createdAt)
    }
}
