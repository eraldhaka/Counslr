package org.counslrapp.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.counslrapp.ui.join_app.JoinListViewModel

/**
 * Created by Erald Haka.
 */

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JoinListViewModel::class.java)) {
            return JoinListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}