package org.counslrapp.ui.join_app

import android.view.View
import androidx.lifecycle.MutableLiveData
import org.counslrapp.R
import org.counslrapp.base.BaseViewModel
import org.counslrapp.model.SchoolModel
import java.util.ArrayList

/**
 * Created by Erald Haka.
 */
class JoinListViewModel(): BaseViewModel(),JoinListAdapter.ChooseSchoolListener{

    val joinListAdapter: JoinListAdapter = JoinListAdapter()
    //val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val onClick: MutableLiveData<Boolean> = MutableLiveData()
    //val onClick = View.OnClickListener { loadPosts() }

    private fun loadPosts() {
        println("loadPosts on error")
    }


    init{
        val myDataModels = ArrayList<SchoolModel>()
        val schoolModel = SchoolModel()
        schoolModel.title = "Molloy College"
        schoolModel.profileImg =  R.drawable.profile_school
        val schoolModel1 = SchoolModel()
        schoolModel1.title = "Molloy College 1"
        schoolModel1.profileImg =  R.drawable.profile_school
        val schoolModel2 = SchoolModel()
        schoolModel2.title = "Molloy College 2"
        schoolModel2.profileImg =  R.drawable.profile_school

        myDataModels.add(schoolModel)
        myDataModels.add(schoolModel1)
        myDataModels.add(schoolModel2)
        joinListAdapter.updatePostList(this,myDataModels)
    }

    override fun onSchoolClicked(viewModel: JoinViewModel) {
        println("onSchoolClicked "+viewModel.getPostTitle().value)
        joinListAdapter.refreshUI()
        onClick.postValue(false)
    }
}
