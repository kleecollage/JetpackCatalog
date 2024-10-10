package com.example.jetpackcomosecatalogo.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var suerHeroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int,
)
