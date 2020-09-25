package com.example.marvelopenapp.viewmodels.factory

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelopenapp.viewmodels.HeroesViewModel

class HeroesViewModelFactory (var context: AppCompatActivity): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeroesViewModel(context) as T
    }

}