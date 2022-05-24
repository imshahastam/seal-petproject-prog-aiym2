package com.example.seal.ui.cafes.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seal.data.models.CafeEntity
import com.example.seal.domain.models.Cafe

class CafeAdapter: RecyclerView.Adapter<CafeViewHolder>() {

    private val items = arrayListOf<Cafe>()

    fun setItems(newItems: List<Cafe>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        return CafeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}