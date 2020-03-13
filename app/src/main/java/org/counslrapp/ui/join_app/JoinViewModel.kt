package org.counslrapp.ui.join_app

import androidx.lifecycle.MutableLiveData
import org.counslrapp.R
import org.counslrapp.base.BaseViewModel
import org.counslrapp.model.SchoolModel

/**
 * Created by Erald Haka.
 */
class JoinViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val profileImage = MutableLiveData<Int>()
    private val background = MutableLiveData<Int>()

    fun bind(post: SchoolModel){
        postTitle.value = post.title
        profileImage.value = post.profileImg
    }

    fun setPosition(){
        background.value = R.drawable.custom_border_clicked
    }

    fun setBackground(){
        background.value = R.drawable.custom_border
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getSchoolProfile():MutableLiveData<Int>{
        return profileImage
    }

    fun getBackground():MutableLiveData<Int>{
        return background
    }
}