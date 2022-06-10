package com.example.imagesearchproject.data
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(
    val id:String,
    val description:String,
    val user: UnsplashUser,
    val urls: UnsplashPhotoUrls,
):Parcelable {

    @Parcelize
    data class UnsplashPhotoUrls(
        val raw:String,
        val full:String,
        val regular:String,
        val small:String,
        val thumb:String,
    ):Parcelable{}

    @Parcelize
    data class UnsplashUser(
        val id:String,
        val username:String,
    ):Parcelable{
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=mykotlinImagesproject&utm_medium=referral"
    }
}