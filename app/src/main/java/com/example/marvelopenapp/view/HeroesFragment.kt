package com.example.marvelopenapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.marvelopenapp.R
import com.example.marvelopenapp.viewmodels.HeroesViewModel
import com.example.marvelopenapp.viewmodels.factory.HeroesViewModelFactory

class HeroesFragment : Fragment() {

    private val viewModel: HeroesViewModel by lazy {
        ViewModelProvider(
            this,
            HeroesViewModelFactory(activity as AppCompatActivity)
        ).get(HeroesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heroes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.heroesList.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            //Build the adapter :D
        })

        viewModel.getHeroes()
    }
}
