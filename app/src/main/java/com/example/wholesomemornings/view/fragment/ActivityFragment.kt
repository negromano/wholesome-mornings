package com.example.wholesomemornings.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wholesomemornings.R
import com.example.wholesomemornings.model.Activity
import com.example.wholesomemornings.model.TestActivity
import com.example.wholesomemornings.view.adapter.ActivitiesAdapter
import com.example.wholesomemornings.view.adapter.ClickableActivityListener
import com.example.wholesomemornings.viewmodel.ActivitiesViewmodel
import kotlinx.android.synthetic.main.fragment_activities_list.*

class ActivityFragment : Fragment(), ClickableActivityListener {

    private lateinit var activitiesAdapter: ActivitiesAdapter
    private lateinit var viewModel: ActivitiesViewmodel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activities_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activitiesAdapter = ActivitiesAdapter(this)
        activitiesAdapter.activities.addAll(listOf(TestActivity("test", 60, "Test Activity")))

         viewModel = ViewModelProviders.of(this).get(ActivitiesViewmodel::class.java)
         viewModel.refresh()

        rvListedActivities.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = activitiesAdapter
        }
        rlBaseSchedule.visibility = View.INVISIBLE
        observeViewModel()
    }

    override fun onActivityClicked(activity: Activity, position: Int) {
    }

    private fun observeViewModel() {
        viewModel.listSchedule.observe(this, Observer<List<Activity>> { activity ->
            activitiesAdapter.updateData(activity)
        })

        viewModel.isLoading.observe(this, Observer<Boolean> {
            if(it != null)
                rlBaseSchedule.visibility = View.INVISIBLE
        })
    }

}
