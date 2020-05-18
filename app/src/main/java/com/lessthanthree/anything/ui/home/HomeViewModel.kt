package com.lessthanthree.anything.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lessthanthree.anything.R

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var listName: ArrayList<String> = arrayListOf()
    private var listImage: ArrayList<Int> = arrayListOf()

    fun initListFeatureName(context: Context?): ArrayList<String> {
        val dataString = context?.resources?.getStringArray(R.array.home_feature_name)
        if(dataString != null) {
            listName.addAll(dataString)
        }

        return listName
    }

    @SuppressLint("Recycle")
    fun initListFeatureImage(context: Context?): ArrayList<Int> {
        val dataImage = context?.resources?.obtainTypedArray(R.array.home_feature_icon)
        if(dataImage != null) {
            for (i in listName.indices) {
                listImage.add(dataImage.getResourceId(i, 0))
            }
        }
        return listImage
    }
}