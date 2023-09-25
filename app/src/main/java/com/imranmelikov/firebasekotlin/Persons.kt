package com.imranmelikov.firebasekotlin

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Persons(
    val person_name:String?="",
    val person_age:Int?=0
)