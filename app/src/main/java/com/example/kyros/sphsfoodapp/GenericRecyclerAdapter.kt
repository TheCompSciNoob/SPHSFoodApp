package com.example.kyros.sphsfoodapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Kyros on 2/17/2018.
 */
class GenericRecyclerAdapter<ITEM> (val itemList : List<ITEM>, private val layoutResId : Int,
                                    private val bindHolder : View.(ITEM) -> Unit,
                                    var itemClick : ITEM.(itemView : View, position : Int) -> Unit)
    : RecyclerView.Adapter<GenericRecyclerAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.itemView?.bindHolder(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent?.context)
        val rootView = inflater.inflate(layoutResId, parent, false)
        val holder = Holder(rootView)
        rootView.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                itemList[adapterPosition].itemClick(rootView, adapterPosition)
            }
        }
        return holder
    }

    class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        //generic
    }
}