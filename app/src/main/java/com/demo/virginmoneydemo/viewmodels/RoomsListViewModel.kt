package com.demo.virginmoneydemo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.virginmoneydemo.data.PeopleRepository
import com.demo.virginmoneydemo.data.RoomRepository
import com.demo.virginmoneydemo.models.People
import com.demo.virginmoneydemo.models.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsListViewModel @Inject internal constructor(
    roomRepo: RoomRepository
) : ViewModel() {
    private var _roomList = MutableLiveData<ArrayList<Room>>()
    val roomList: LiveData<ArrayList<Room>>
        get() = _roomList

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        onError(exception.message.toString())
    }


    init {
        viewModelScope.launch(coroutineExceptionHandler) {
            val response = roomRepo.getRoomsList()
            if (response.isSuccessful) {
                _roomList.postValue(response.body())
            } else {
                onError(response.message())
            }
        }
    }

    private fun onError(message: String) {
        Log.e(this::class.simpleName, message)
    }
}
