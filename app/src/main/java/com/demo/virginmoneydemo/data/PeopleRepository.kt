package com.demo.virginmoneydemo.data

import com.demo.virginmoneydemo.models.People
import com.demo.virginmoneydemo.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val service: ApiService) {
    suspend fun getPeoplesStream() = withContext(Dispatchers.IO) {service.fetchPeoples()}
}


