package com.example.imagesearchproject.data

import android.util.Log
import androidx.paging.PagingSource
import com.example.imagesearchproject.api.UnsplashApi
import retrofit2.HttpException
import java.io.IOException

const val UNSPLASH_STARTING_PAGE_INDEX = 1
const val TAG = "_UnsplashPagingSource"
class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query:String
):PagingSource<Int,UnsplashPhoto>()
{
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key?:UNSPLASH_STARTING_PAGE_INDEX
        return try{
            Log.d(TAG, "load: 1")
            val reponse = unsplashApi.searchPhotos(query,position,params.loadSize)
            Log.d(TAG, "load: response is : $reponse")
            val photos = reponse.results
            Log.d(TAG, "load: photos: $photos")
            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position-1,
                nextKey = if (photos.isEmpty()) null else position+1
            )
        }
        catch (exception: IOException){return LoadResult.Error(exception)}
        catch (exception: HttpException){ return LoadResult.Error(exception)}
    }
}