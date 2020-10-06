package com.example.wholesomemornings.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wholesomemornings.R
import com.example.wholesomemornings.model.entities.Activity
import com.example.wholesomemornings.view.adapter.ActivitiesAdapter
import com.example.wholesomemornings.view.adapter.ClickableActivityListener
import com.example.wholesomemornings.viewmodel.ActivitiesViewmodel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_activities_list.*


class ActivityFragment : Fragment(), ClickableActivityListener {

    private lateinit var activitiesAdapter: ActivitiesAdapter
    private lateinit var viewModel: ActivitiesViewmodel
    private lateinit var currentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentView = inflater.inflate(R.layout.fragment_activities_list, container, false)
        val createsActivityButton =
            currentView.findViewById(R.id.createActivityButton) as FloatingActionButton
        createsActivityButton.setOnClickListener(this::onCreateActivity)
        return currentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activitiesAdapter = ActivitiesAdapter(this)

        viewModel = ViewModelProviders.of(this).get(ActivitiesViewmodel::class.java)
        activity?.applicationContext?.let { viewModel.refresh(it) }

        rvListedActivities.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = activitiesAdapter
        }
        observeViewModel()
    }

    override fun onActivityClicked(activity: Activity, position: Int) {
    }

    private fun observeViewModel() {
        viewModel.listActivities.observe(viewLifecycleOwner, Observer<List<Activity>> { activity ->
            activitiesAdapter.updateData(activity)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it != null)
                loadingBar.visibility = View.INVISIBLE
        })
    }

    private fun onCreateActivity(view: View) {
        val action = ActivityFragmentDirections.actionActivityFragmentToCreateActivityFragment3()
        view.findNavController().navigate(action)
    }

}
