package org.counslrapp.ui.join_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import org.counslrapp.R
import org.counslrapp.base.ViewModelFactory
import org.counslrapp.databinding.ActivityJoinBinding

class JoinListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding
    private lateinit var viewModel: JoinListViewModel


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_join)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(JoinListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel
    }

    private fun showError(errorMessage:Int){
       //here will be shown error if data will be parsed from backend
    }

    private fun hideError(){
        //here will be hide error if data will be parsed from backend
    }
}
