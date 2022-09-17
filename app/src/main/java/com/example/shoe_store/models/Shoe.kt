package com.example.shoe_store.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(var name: String = " ", var size: Double?= null, var company: String="", var description: String="",
                ) : Parcelable


