package com.example.seal.ui.cafes.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seal.R
import com.example.seal.data.models.CafeEntity
import com.example.seal.databinding.ItemRecyclerBinding
import com.example.seal.domain.models.Cafe

class CafeViewHolder(private val binding: ItemRecyclerBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Cafe) {
            binding.cafeNameTxt.text = item.name
        }

    companion object {
        fun create(parent: ViewGroup) : CafeViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler, parent, false)

            return CafeViewHolder(ItemRecyclerBinding.bind(view))
        }
    }
}