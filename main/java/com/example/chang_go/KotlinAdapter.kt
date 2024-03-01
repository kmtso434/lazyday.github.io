package com.example.chang_go

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class KotlinAdapter (private var mList: List<KotilinData>) :
    RecyclerView.Adapter<KotlinAdapter.KotlinViewHolder>() {
        inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val titleTv: TextView = itemView.findViewById(R.id.titleTv)
            val langDescTv: TextView = itemView.findViewById(R.id.langDesc)
            val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)

            fun collapeExpandedView(){
                langDescTv.visibility = View.GONE
            }
        }

    fun setFilteredList(mList: List<KotilinData>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: KotlinViewHolder, position: Int) {
        val KotilinData = mList[position]
        holder.titleTv.text = KotilinData.title
        holder.kotDescTv.text = KotilinData.desc

        val isExpandable: Boolean = KotilinData.isExpandable
        holder.kotDescTv.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.constraintLayout.setOnClickListner {
            isAnyItemExpanded(position)
            KotilinData.isExpandable = !KotilinData.isExpandable
            notifyItemChanged(position , Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int){
        val temp = mList.indexOfFirst {
            it.isExpandable
        }
        if (temp >= 0 && temp != position){
            mList[temp].isExpandable = false
            notifyItemChanged(temp , 0)
        }
    }

    override fun onBindViewHolder(
        holder: KotlinViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}