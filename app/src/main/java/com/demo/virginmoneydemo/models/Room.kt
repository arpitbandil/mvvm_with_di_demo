package com.demo.virginmoneydemo.models

data class Room(
    val createdAt: String,
    val id: String,
    val isOccupied: Boolean,
    val maxOccupancy: Int
)