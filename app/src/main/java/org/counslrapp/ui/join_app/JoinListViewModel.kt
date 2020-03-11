package org.counslrapp.ui.join_app

import android.view.View
import androidx.lifecycle.MutableLiveData
import org.counslrapp.base.BaseViewModel
import org.counslrapp.model.SchoolModel
import java.util.ArrayList

/**
 * Created by Erald Haka.
 */
class JoinListViewModel(): BaseViewModel(){

    val joinListAdapter: JoinListAdapter = JoinListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    private fun loadPosts() {
        println("loadPosts on error")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

   // private lateinit var subscription: Disposable

    init{
        //loadPosts()
        val myDataModel = SchoolModel()
        myDataModel.title = "Erald"
        val myDataModels = ArrayList<SchoolModel>()
        myDataModels.add(myDataModel)
        joinListAdapter.updatePostList(myDataModels)
    }

    override fun onCleared() {
        super.onCleared()
       // subscription.dispose()
    }
}