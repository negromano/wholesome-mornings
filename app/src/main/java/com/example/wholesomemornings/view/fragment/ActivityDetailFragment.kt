package com.example.wholesomemornings.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.wholesomemornings.R
import kotlinx.android.synthetic.main.fragment_activities_list.*
import kotlinx.android.synthetic.main.fragment_activity_details.view.*

class ActivityDetailFragment : Fragment() {
    private lateinit var currentView: View
    val args: ActivityDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentView = inflater.inflate(R.layout.fragment_activity_details, container, false)
        return currentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.etActivityName.text = args.detailedActivity.name
        view.etActivityDescription.text = args.detailedActivity.additionalData
        processFinished()
    }

    private fun processFinished() {
        loadingBar.visibility = View.INVISIBLE
    }
}