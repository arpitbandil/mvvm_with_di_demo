package com.demo.virginmoneydemo.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.demo.virginmoneydemo.data.PeopleRepository
import com.demo.virginmoneydemo.utils.MainCoroutineRule
import com.demo.virginmoneydemo.utils.runBlockingTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject
import kotlin.jvm.Throws

@HiltAndroidTest
class PeopleViewModelTest {

    private lateinit var viewModel: PeopleViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)
        .around(coroutineRule)

    @Inject
    lateinit var peopleRepository: PeopleRepository

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = PeopleViewModel(peopleRepository)
        Thread.sleep(13000)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() = coroutineRule.runBlockingTest {
        assertFalse(viewModel.peopleList.value.isNullOrEmpty())
    }
}
