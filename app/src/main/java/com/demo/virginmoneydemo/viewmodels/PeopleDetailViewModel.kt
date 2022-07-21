package com.demo.virginmoneydemo.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.virginmoneydemo.models.People
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.demo.virginmoneydemo.ui.people.PeopleDetailFragment

/**
 * The ViewModel used in [PeopleDetailFragment].
 */
@HiltViewModel
class PeopleDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    val people = savedStateHandle.get<People>(PEOPLE_SAVED_STATE_KEY)!!

    companion object {
        private const val PEOPLE_SAVED_STATE_KEY = "people"
    }
}