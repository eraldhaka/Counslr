package org.counslrapp.ui.join_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_join.*
import org.counslrapp.R
import org.counslrapp.base.ViewModelFactory
import org.counslrapp.databinding.ActivityJoinBinding
import org.counslrapp.ui.home.HomeActivity

class JoinListActivity : AppCompatActivity(){

    private lateinit var binding: ActivityJoinBinding
    private lateinit var viewModel: JoinListViewModel

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(JoinListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })

        viewModel.onClick.observe(this, Observer {
            textViewNext.isClickable
            textViewNext.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
        })

        binding.viewModel = viewModel

        imageViewBack.setOnClickListener { finish() }
        textViewNext.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showError(errorMessage:Int){
        //here will be shown error if data will be parsed from backend
    }

    private fun hideError(){
        //here will be hide error if data will be parsed from backend
    }


}
