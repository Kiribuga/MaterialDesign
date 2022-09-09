package com.example.materialdesign.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.materialdesign.R
import com.example.materialdesign.data.AdapterMusic
import com.example.materialdesign.data.ItemData
import com.example.materialdesign.databinding.FragmentMainBinding
import com.example.materialdesign.utill.autoCleared

class MainFragment : Fragment(R.layout.fragment_main) {

    private val vBinding: FragmentMainBinding by viewBinding()
    private var adapterAlbum: AdapterMusic by autoCleared()
    private val cardsAlbums = listOf(
        ItemData(
            image = R.drawable.image_1,
            title = "Vices & Virtues",
            year = "2011 year"
        ),
        ItemData(
            image = R.drawable.image_2,
            title = "Too Weird to Live, Too Rare to Die",
            year = "2013 year"
        ),
        ItemData(
            image = R.drawable.image_3,
            title = "Pray for the Wicked",
            year = "2018 year"
        ),
        ItemData(
            image = R.drawable.image_4,
            title = "Death of a Bachelor",
            year = "2016 year"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListCard()
        adapterAlbum.albumList = cardsAlbums
    }

    private fun initListCard() {
        adapterAlbum = AdapterMusic()
        with(vBinding.recyclerView) {
            adapter = adapterAlbum
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2).apply {
                orientation = GridLayoutManager.VERTICAL
            }
        }
    }

}