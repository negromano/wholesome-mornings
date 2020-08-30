package com.example.wholesomemornings.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wholesomemornings.model.db.AppDatabase
import com.example.wholesomemornings.model.entities.Activity
import com.example.wholesomemornings.model.entities.ListedActivity

class ActivitiesViewmodel : ViewModel() {
    var listActivities: MutableLiveData<List<Activity>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()
    var database: AppDatabase? = null

    fun refresh(context: Context) {
        database = AppDatabase.getInstance(context)
        getActivitiesData()
    }

    private fun getActivitiesData() {
        /*listActivities.postValue(listOf(
            TestActivity(
                "test",
                "Test Activity FROM VIEWMODEL"
            )
        ))*/
        database?.activityDao()?.insertAll(
            ListedActivity(
                "test"
            )
        )
        var data = database?.activityDao()?.getAll()
        print(data)
        listActivities.postValue(data)
        processFinished()
    }

    fun processFinished() {
        isLoading.value = true
    }
}
