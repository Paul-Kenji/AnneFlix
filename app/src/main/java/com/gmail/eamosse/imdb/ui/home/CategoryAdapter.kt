package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.CategoryListItemBinding
import kotlinx.android.synthetic.main.category_list_item.*

class CategoryAdapter(private val items: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val img: ImageView = binding.categoryImg.findViewById(R.id.category_img)
        fun bind(item: Category) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CategoryListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToHomeSecondFragment(items[position].id.toString())
            findNavController(it).navigate(action)
        }
        if (position == 0) {
            holder.img.setImageResource(R.drawable.action)
        }
        if (position == 1) {
            holder.img.setImageResource(R.drawable.adventure)
        }
        if (position == 2) {
            holder.img.setImageResource(R.drawable.animation)
        }
        if (position == 3) {
            holder.img.setImageResource(R.drawable.comedy)
        }
        if (position == 4) {
            holder.img.setImageResource(R.drawable.crime)
        }
        if (position == 5) {
            holder.img.setImageResource(R.drawable.drama)
        }
        if (position == 6) {
            holder.img.setImageResource(R.drawable.documentary)
        }
        if (position == 7) {
            holder.img.setImageResource(R.drawable.family)
        }
        if (position == 8) {
            holder.img.setImageResource(R.drawable.fantasy)
        }
        if (position == 9) {
            holder.img.setImageResource(R.drawable.history)
        }
        if (position == 10) {
            holder.img.setImageResource(R.drawable.horror)
        }
        if (position == 11) {
            holder.img.setImageResource(R.drawable.music)
        }
        if (position == 12) {
            holder.img.setImageResource(R.drawable.mystery)
        }
        if (position == 13) {
            holder.img.setImageResource(R.drawable.romance)
        }
        if (position == 14) {
            holder.img.setImageResource(R.drawable.sciencefiction)
        }
        if (position == 15) {
            holder.img.setImageResource(R.drawable.thriller)
        }
        if (position == 16) {
            holder.img.setImageResource(R.drawable.tvmovie)
        }
        if (position == 17) {
            holder.img.setImageResource(R.drawable.war)
        }
        if (position == 18) {
            holder.img.setImageResource(R.drawable.western)
        }
    }
}
