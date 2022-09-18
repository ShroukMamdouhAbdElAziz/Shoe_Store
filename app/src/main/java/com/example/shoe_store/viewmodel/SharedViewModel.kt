package com.example.shoe_store.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoe_store.models.Shoe


class SharedViewModel : ViewModel() {

    // empty
    var listLiveData = MutableLiveData<MutableList<Shoe>>(mutableListOf())


         fun addShoe(shoe: Shoe) {

        listLiveData.value?.add(shoe)

    }

}