package com.example.cc1_android

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (
    val name : String,
    val brand : String,
    val barcode : String,
    val nutriscore : String,
    val quantity  : String,
    val allergenicSubstances : List<String>,
    val ingredients : List<String>,
    val additifs: List<String>,
    val countries : List<String>,
    val urlImg: Int
) : Parcelable {}



