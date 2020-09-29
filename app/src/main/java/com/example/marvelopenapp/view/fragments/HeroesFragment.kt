package com.example.marvelopenapp.view.fragments

import Heros
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelopenapp.R
import com.example.marvelopenapp.view.adapters.HeroesAdapter
import com.example.marvelopenapp.viewmodels.HeroesViewModel
import com.example.marvelopenapp.viewmodels.factory.HeroesViewModelFactory
import kotlinx.android.synthetic.main.fragment_heroes.*

class HeroesFragment : Fragment() {

    private val viewModel: HeroesViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            HeroesViewModelFactory(activity as AppCompatActivity)
        ).get(HeroesViewModel::class.java)
    }

    private lateinit var adapter: HeroesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heroes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.heroesList.observe(viewLifecycleOwner, observerHeroes())

        adapter = HeroesAdapter((activity as AppCompatActivity), viewModel.getHeroes())
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter

        viewModel.getHeroesFromWebService()
    }


    private fun observerHeroes(): Observer<MutableList<Heros>> {
        return Observer{heroesList ->
            adapter?.updateList(heroesList)
        }
    }
}
