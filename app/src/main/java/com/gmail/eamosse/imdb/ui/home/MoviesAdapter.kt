package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.eamosse.idbdata.data.CategoryMovies
import com.gmail.eamosse.imdb.databinding.FragmentMoviesBinding

class MoviesAdapter(private val items: List<CategoryMovies>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: FragmentMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgmovie = binding.imageView2
        fun bind(item: CategoryMovies) {
            binding.itemMovie = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(FragmentMoviesBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
        Glide.with(holder.imgmovie.context)
            .load("https://image.tmdb.org/t/p/w500/" + items[position].poster_path)
            .into(holder.imgmovie)
        holder.itemView.setOnClickListener {
            val action =
                HomeSecondFragmentDirections.actionHomeSecondFragmentToThirdFragment(items[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}
