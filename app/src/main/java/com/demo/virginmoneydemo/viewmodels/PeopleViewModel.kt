package com.demo.virginmoneydemo.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.demo.virginmoneydemo.data.PeopleRepository
import com.demo.virginmoneydemo.models.People
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject internal constructor(
    peopleRepo: PeopleRepository
) : ViewModel() {
    private var _peopleList = MutableLiveData<ArrayList<People>>()
    val peopleList: LiveData<ArrayList<People>>
        get() = _peopleList

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        onError(exception.message.toString())
    }


    init {
        viewModelScope.launch(coroutineExceptionHandler) {
            val response = peopleRepo.getPeoplesStream()
            if (response.isSuccessful) {
                _peopleList.postValue(response.body())
            } else {
                onError(response.message())
            }
        }
    }

    private fun onError(message: String) {
        Log.e(this::class.simpleName, message)
    }
}
