package com.example.wholesomemornings.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wholesomemornings.model.entities.Activity
import com.example.wholesomemornings.model.entities.TestActivity

class ActivitiesViewmodel : ViewModel() {
    var listActivities: MutableLiveData<List<Activity>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getActivitiesData()
    }

    private fun getActivitiesData() {
        listActivities.postValue(listOf(
            TestActivity(
                "test",
                "Test Activity FROM VIEWMODEL"
            )
        ))
        processFinished()
    }

    fun processFinished() {
        isLoading.value = true
    }
}