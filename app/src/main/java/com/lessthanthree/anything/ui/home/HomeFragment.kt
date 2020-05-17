package com.lessthanthree.anything.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lessthanthree.anything.R
import com.lessthanthree.anything.adapter.HomeAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var rvhome :RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        rvhome = root.findViewById(R.id.rvHome)
        rvhome.setHasFixedSize(true)
        rvhome.layoutManager = GridLayoutManager(this.context, 2)

        homeViewModel.initListFeatureName(this.context)
        val homeAdapter = HomeAdapter(homeViewModel.initListFeatureImage(this.context))
        rvhome.adapter = homeAdapter

        return root
    }
}