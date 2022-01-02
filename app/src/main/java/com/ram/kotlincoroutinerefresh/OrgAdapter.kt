package com.ram.kotlincoroutinerefresh

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ram.kotlincoroutinerefresh.databinding.OrgLayoutBinding
import com.ram.kotlincoroutinerefresh.model.OrgModel

class OrgAdapter (context : Context): RecyclerView.Adapter<OrgAdapter.OrgViewHolder>(){
    var mContext : Context?=null
    var orgList : MutableList<OrgModel> ? =null
    init {
        mContext = context
    }
    fun setOrgsData(list : MutableList<OrgModel>){
        orgList=list
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrgAdapter.OrgViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val orgLayoutBinding = OrgLayoutBinding.inflate(inflater,null,false)
        return OrgViewHolder(orgLayoutBinding,mContext!!)
    }

    override fun onBindViewHolder(holder: OrgAdapter.OrgViewHolder, position: Int) {
       holder.displayData(orgList!!.get(position))
    }

    override fun getItemCount(): Int {
        return orgList!!.size
    }
    class OrgViewHolder(binding : OrgLayoutBinding,ctc :Context) : RecyclerView.ViewHolder(binding.root){
        val bind = binding
        fun displayData(data : OrgModel){
            bind.orgdata = data;
            bind.executePendingBindings()
        }
    }

}