package com.example.krakg.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.adapters.BotCardAdapter
import com.example.krakg.DataManager
import com.example.krakg.R
import kotlinx.android.synthetic.main.fragment_bots.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val myList = listOf("Title One", "Title Two", "Title Three", "Title Four")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bots, container, false)
 //       val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(activity!!, Observer {
            //textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_bots.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BotCardAdapter(myList, activity!!)
        recyclerView_bots.adapter = adapter

        DataManager.getServerTime()
    }
}