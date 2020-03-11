package org.counslrapp.ui.join_app

import androidx.lifecycle.MutableLiveData
import org.counslrapp.base.BaseViewModel
import org.counslrapp.model.SchoolModel

/**
 * Created by Erald Haka.
 */
class JoinViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()

    fun bind(post: SchoolModel){
        postTitle.value = post.title
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }
}