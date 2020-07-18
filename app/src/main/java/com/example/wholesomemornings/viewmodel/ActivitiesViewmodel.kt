package com.example.wholesomemornings.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wholesomemornings.model.Activity
import com.example.wholesomemornings.model.TestActivity
import java.lang.Exception
import com.example.wholesomemornings.network.Callback

class ActivitiesViewmodel : ViewModel() {
    var listSchedule: MutableLiveData<List<Activity>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getActivitiesData()
    }

    private fun getActivitiesData() {
        listSchedule.postValue(listOf(TestActivity("test", 60, "Test Activity")))
        processFinished()
    }

    fun processFinished() {
        isLoading.value = true
    }

}