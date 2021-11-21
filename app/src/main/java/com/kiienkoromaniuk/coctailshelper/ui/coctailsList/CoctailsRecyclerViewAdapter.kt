package com.kiienkoromaniuk.coctailshelper.ui.coctailsList

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kiienkoromaniuk.coctailshelper.data.models.Drink
import com.kiienkoromaniuk.coctailshelper.databinding.FragmentCoctailsBinding

import com.kiienkoromaniuk.coctailshelper.ui.coctailsList.placeholder.PlaceholderContent.PlaceholderItem


class CoctailsRecyclerViewAdapter(
    private val values: List<Drink>, private val context: Context
) : RecyclerView.Adapter<CoctailsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCoctailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.contentView.text = item.strDrink
        Glide
            .with(context)
            .load(item.strDrinkThumb)
            .centerCrop()
            .into(holder.img);
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCoctailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content
        val img: ImageView = binding.img

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}