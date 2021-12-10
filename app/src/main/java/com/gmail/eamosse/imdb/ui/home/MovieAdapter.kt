package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Movie
import com.gmail.eamosse.imdb.databinding.FragmentMovieBinding


class MovieAdapter(private val items: Movie) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: FragmentMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            binding.itemParamMovie = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(FragmentMovieBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(items)
        holder.itemView.setOnClickListener {
            val action =
                HomeThirdFragmentDirections.actionThirdFragmentToHomeSecondFragment(items.id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}
