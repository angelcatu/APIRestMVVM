package com.tzikin.chucknorrisapi.view.ChuckNorrisListAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tzikin.chucknorrisapi.R
import com.tzikin.chucknorrisapi.repository.model.JokeResponse

class ChuckNorrisListAdapter(var jokes: MutableList<JokeResponse>) :
    RecyclerView.Adapter<ChuckNorrisListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chuck_norris_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount(): Int {
        if(!jokes.isNullOrEmpty()){
            return jokes.size
        }
        return 0
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var iv_chuck_norris = view.findViewById<ImageView>(R.id.iv_chuck_norris)
        var tv_joke = view.findViewById<TextView>(R.id.tv_joke)

        fun bind(joke: JokeResponse) {
            Picasso.get().load(joke.icon_url).into(iv_chuck_norris)
            tv_joke.text = joke.value
        }

    }
}