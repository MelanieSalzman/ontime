package com.ort.ontime.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.ontime.R
import com.ort.ontime.adapters.StoreListAdapter
import com.ort.ontime.entities.Store

class ListFragment : Fragment() {

    lateinit var v: View
    lateinit var recStores: RecyclerView

    var storesList : MutableList<Store> = ArrayList<Store>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var storesListAdapter : StoreListAdapter

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.list_fragment, container, false)
        recStores = v.findViewById(R.id.rec_stores)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        storesList.add(Store("La Alameda","Esta es la descripción1"))
        storesList.add(Store("Guerrín","Esta es la descripción2"))
        storesList.add(Store("Kentucky","Esta es la descripción3"))
        storesList.add(Store("San Justo","Esta es la descripción4"))

        recStores.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(context)
        recStores.layoutManager = linearLayoutManager

        storesListAdapter = StoreListAdapter(storesList){store -> onItemClick(store)}

        recStores.adapter = storesListAdapter
    }

    fun onItemClick (position: Int) {
        //Snackbar.make(v,position.toString(),Snackbar.LENGTH_SHORT).show()
        val action = ListFragmentDirections.actionListFragmentToStoreDetailsFragment(storesList[position])
        v.findNavController().navigate(action)

    }
}