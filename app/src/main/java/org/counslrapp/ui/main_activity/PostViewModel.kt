package org.counslrapp.ui.main_activity

import androidx.lifecycle.MutableLiveData
import org.counslrapp.base.BaseViewModel
import org.counslrapp.model.SliderItems


class PostViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()

    fun bind(post: SliderItems){
        postTitle.value = post.description
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }
}