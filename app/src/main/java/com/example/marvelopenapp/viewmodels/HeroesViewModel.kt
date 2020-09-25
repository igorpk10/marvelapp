package com.example.marvelopenapp.viewmodels

import Heros
import MarvelObject
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelopenapp.webservice.MarvelServices

class HeroesViewModel(var context: AppCompatActivity) : ViewModel() {
    var heroesList = MutableLiveData<MutableList<Heros>>()
    private var offset: Int = 0

    //call webservice method
    fun getHeroes() {
        MarvelServices().callHeroesList(context, offset) {
            heroesList.value = getOnlyHeroesResult(it)
            offset.plus(heroesList.value!!.size)
        }
    }

    //Filter the response to get only heroes result :D
    private fun getOnlyHeroesResult(responseObject: MarvelObject): MutableList<Heros> {
        return responseObject.data.results.toMutableList()
    }

}