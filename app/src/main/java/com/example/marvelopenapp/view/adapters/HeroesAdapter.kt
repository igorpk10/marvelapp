package com.example.marvelopenapp.view.adapters

import Heros
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.example.marvelopenapp.R
import kotlinx.android.synthetic.main.adapter_heroes.view.*

class HeroesAdapter(
    var context: AppCompatActivity,
    var list: MutableList<Heros> = mutableListOf()
) : RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    fun updateList(list: MutableList<Heros>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: AppCompatImageView = view.image
        val title: TextView = view.title
        val description: TextView = view.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_heroes, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]


        Glide.with(context)
            .load("${item.thumbnail.path}/landscape_incredible.${item.thumbnail.extension}")
            .transition(withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.image)

        holder.title.apply {
            this.text = item.name
        }

        holder.description.apply {
            this.text = item.description
        }
    }
}