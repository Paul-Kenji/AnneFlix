package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.CategoryMovies
import com.gmail.eamosse.imdb.databinding.FragmentMoviesBinding
import com.gmail.eamosse.imdb.hello

class MoviesAdapter(private val items: List<CategoryMovies>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: FragmentMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
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
        holder.itemView.setOnClickListener {
            val action =
                HomeSecondFragmentDirections.actionHomeSecondFragmentToThirdFragment(position.toString())
            Navigation.findNavController(it).navigate(action)
            hello = getItemId(position).toInt()
        }
    }
}
