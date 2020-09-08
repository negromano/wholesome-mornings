package com.example.wholesomemornings.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wholesomemornings.R
import com.example.wholesomemornings.model.entities.Activity
import com.example.wholesomemornings.view.adapter.ActivitiesAdapter
import com.example.wholesomemornings.view.adapter.ClickableActivityListener
import com.example.wholesomemornings.viewmodel.ActivitiesViewmodel
import kotlinx.android.synthetic.main.fragment_activities_list.*

class CreateActivityFragment : Fragment(), ClickableActivityListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_activity_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityClicked(activity: Activity, position: Int) {
    }

}
