package com.ort.ontime.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ort.ontime.R
import com.ort.ontime.entities.Store

class StoreDetailsFragment : Fragment() {

    lateinit var v: View
    lateinit var nameStore : TextView
    lateinit var descriptionStore : TextView
    lateinit var store : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v= inflater.inflate(R.layout.store_details_fragment, container, false)
        nameStore = v.findViewById(R.id.nameStoreTxt)
        descriptionStore = v.findViewById(R.id.descriptionStoreTxt)
        return v
    }

    override fun onStart() {
        super.onStart()

        store = StoreDetailsFragmentArgs.fromBundle(requireArguments()).store
        setupView()
    }

    fun setupView () {
        nameStore.text = store.name
        descriptionStore.text = store.description
    }


}