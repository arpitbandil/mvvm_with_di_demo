package com.demo.virginmoneydemo.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.demo.virginmoneydemo.data.RoomRepository
import com.demo.virginmoneydemo.utils.MainCoroutineRule
import com.demo.virginmoneydemo.utils.runBlockingTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject
import kotlin.jvm.Throws

@HiltAndroidTest
class RoomsListViewModelTest {

    private lateinit var viewModel: RoomsListViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)
        .around(coroutineRule)

    @Inject
    lateinit var roomRepository: RoomRepository

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = RoomsListViewModel(roomRepository)
        Thread.sleep(5000)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() = coroutineRule.runBlockingTest {
        assertFalse(viewModel.roomList.value.isNullOrEmpty())
    }
}
