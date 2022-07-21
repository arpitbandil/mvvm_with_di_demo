package com.demo.virginmoneydemo.models

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

class RoomTest {

    private lateinit var room: Room

    @Before
    fun setUp() {
        room = Room(
            "2022-01-24T17:02:23.729Z",
            "1",
            true,
            234,
        )
    }

    @Test
    fun test_default_values() {
        assertEquals("1", room.id)
        assertEquals(234, room.maxOccupancy)
        assertEquals(true, room.isOccupied)
        assertEquals("2022-01-24T17:02:23.729Z", room.createdAt)
    }
}
