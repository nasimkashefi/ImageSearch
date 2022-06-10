package com.example.imagesearchproject.api

import com.example.imagesearchproject.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)