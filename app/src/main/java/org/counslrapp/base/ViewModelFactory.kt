package org.counslrapp.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.counslrapp.model.SliderItems
/**
 * Created by Erald Haka.
 */

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SliderItems::class.java)) {
            return SliderItems() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}