package com.ravimhzn.daggerinkotlin.ui.main.post

import android.util.Log
import androidx.lifecycle.*
import com.ravimhzn.daggerinkotlin.SessionManager
import com.ravimhzn.daggerinkotlin.models.Posts
import com.ravimhzn.daggerinkotlin.network.main.PostAPI
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class PostViewModel @Inject constructor(
    private val sessionManager: SessionManager,
    private val postAPI: PostAPI
) : ViewModel() {

    private val TAG = PostViewModel::class.java.name
    private val mediatorLiveData = MediatorLiveData<PostResource<List<Posts>>>()

    init {
        Log.d(TAG, "POST VIEW MODEL IS WORKING")
    }

    fun observePosts(): LiveData<PostResource<List<Posts>>> {
        mediatorLiveData.value = PostResource.Loading(null) //Show Loading status
        val id: Int? = sessionManager.getAuthUser().value?.data?.id
        var source = LiveDataReactiveStreams.fromPublisher(
            postAPI.getPost(id!!) //Force Unwrap - Review it again - it might cause nullpointer exception if id = null
                .onErrorReturn(Function {
                    var p = Posts()
                    p.id = -1
                    var pArr = ArrayList<Posts>()
                    pArr.add(p)
                    pArr
                })
                .map { t ->
                    if (t[0].id == -1) {
                        PostResource.Error("Something went wrong", null)
                    }
                    PostResource.Success(t)
                }
                .subscribeOn(Schedulers.io())

        )

        mediatorLiveData.addSource(source, Observer {
            mediatorLiveData.value = it
            mediatorLiveData.removeSource(source)
        })
        return mediatorLiveData
    }
}



