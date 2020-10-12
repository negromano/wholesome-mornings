package com.example.wholesomemornings.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.wholesomemornings.model.db.AppDatabase
import com.example.wholesomemornings.R
import com.example.wholesomemornings.model.entities.ListedActivity
import kotlinx.android.synthetic.main.fragment_activities_list.*
import com.example.wholesomemornings.utils.Toaster

class CreateActivityFragment : Fragment() {
    private var database: AppDatabase? = null
    private lateinit var currentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentView = inflater.inflate(R.layout.fragment_create_activity_form, container, false)
        val saveActivityButton =
            currentView.findViewById(R.id.saveActivityButton) as Button
        saveActivityButton.setOnClickListener(this::createActivity)
        return currentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        processFinished()
    }

    private fun processFinished() {
        loadingBar.visibility = View.INVISIBLE
    }

    private fun createActivity(view: View) {
        database = activity?.applicationContext?.let { AppDatabase.getInstance(it) }
        val title = currentView.findViewById(R.id.etActivityName) as EditText
        val description = currentView.findViewById(R.id.etActivityDescription) as EditText
        database?.activityDao()?.insertAll(
            ListedActivity(
                title.text.toString(),
                "Listada",
                description.text.toString()
            )
        )
        activity?.applicationContext?.let { Toaster.shortToast(it, "Activity Created") }
        val action =
            CreateActivityFragmentDirections.actionCreateActivityFragmentToActivityFragment()
        view.findNavController().navigate(action)
    }

}
