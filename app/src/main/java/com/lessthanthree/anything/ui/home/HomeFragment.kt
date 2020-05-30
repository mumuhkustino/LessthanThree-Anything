package com.lessthanthree.anything.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lessthanthree.anything.R
import com.lessthanthree.anything.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this)[HomeViewModel::class.java]

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvHome.setHasFixedSize(true)
        rvHome.layoutManager = GridLayoutManager(context, 2)

        val homeAdapter = HomeAdapter(homeViewModel.initListFeatureName(context), homeViewModel.initListFeatureImage(context))
        rvHome.adapter = homeAdapter
    }
}