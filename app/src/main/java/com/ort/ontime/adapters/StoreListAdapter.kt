package com.ort.ontime.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ort.ontime.R
import com.ort.ontime.entities.Store
import kotlinx.android.synthetic.main.item_store.view.*

class StoreListAdapter(private var storesList: MutableList<Store>,val onItemClick : (Int) -> Unit) : RecyclerView.Adapter<StoreListAdapter.StoreHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store,parent,false)
        return (StoreHolder(
            view
        ))
    }

    override fun getItemCount(): Int {
        return storesList.size
    }

    /*fun setData(newData: ArrayList<Store>) {
        this.storesList = newData
        this.notifyDataSetChanged()
    }*/

    override fun onBindViewHolder(holder: StoreHolder, position: Int) {
        holder.setName(storesList[position].name)

        holder.getCardLayout().setOnClickListener{
            onItemClick(position)
        }
    }

    class StoreHolder (v: View) : RecyclerView.ViewHolder(v){
        private var view: View

        init{
            this.view = v
        }

        fun setName(name: String){
            val txt: TextView = view.findViewById(R.id.store_name_text)
            txt.text = name
        }

        fun getCardLayout ():CardView{
            return view.findViewById(R.id.item_store)
        }
    }
}