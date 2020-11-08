package com.example.wholesomemornings.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wholesomemornings.model.db.AppDatabase
import com.example.wholesomemornings.model.entities.Activity

class ActivitiesViewmodel : ViewModel() {
    var listActivities: MutableLiveData<List<Activity>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()
    var database: AppDatabase? = null

    fun refresh(context: Context) {
        database = AppDatabase.getInstance(context)
        getActivitiesData()
    }

    private fun getActivitiesData() {
        val data = database?.activityDao()?.getAll()
        listActivities.postValue(data)
        processFinished()
    }

    private fun processFinished() {
        isLoading.value = true
    }
}
