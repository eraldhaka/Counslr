package org.counslrapp.ui.join_app

import androidx.lifecycle.MutableLiveData
import org.counslrapp.base.BaseViewModel
import org.counslrapp.model.SchoolModel

/**
 * Created by Erald Haka.
 */
class JoinViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val profileImage = MutableLiveData<Int>()

    fun bind(post: SchoolModel){
        postTitle.value = post.title
        profileImage.value = post.profileImg
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getSchoolProfile():MutableLiveData<Int>{
        return profileImage
    }
}