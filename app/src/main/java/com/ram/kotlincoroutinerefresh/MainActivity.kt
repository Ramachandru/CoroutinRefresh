package com.ram.kotlincoroutinerefresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ram.kotlincoroutinerefresh.viewmodel.OrgViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: OrgViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        val orgAdapter=OrgAdapter(this)
        orgAdapter.setOrgsData(mutableListOf())
        viewModel = ViewModelProvider(this@MainActivity).get(OrgViewModel::class.java)
        viewModel.getOrgLiveData().observe(this,Observer{ orgValue->
            orgAdapter.setOrgsData(orgValue)
            orgAdapter.notifyDataSetChanged()
        })
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=orgAdapter
    }
}