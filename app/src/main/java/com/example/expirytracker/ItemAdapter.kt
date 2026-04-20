package com.example.expirytracker

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private val ctx: Context,
    private val list: List<ExpiryItem>,
    private val onClick: (ExpiryItem) -> Unit
) : RecyclerView.Adapter<ItemAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvEmoji: TextView = view.findViewById(R.id.tvItemEmoji)
        val tvName: TextView = view.findViewById(R.id.tvItemName)
        val tvStatus: TextView = view.findViewById(R.id.tvExpiryStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_expiry_row, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = list[position]
        holder.tvName.text = item.name
        holder.tvStatus.text = item.status
        if (item.isExpired) {
            holder.tvEmoji.text = "⚠️"
            holder.tvStatus.setTextColor(Color.parseColor("#D32F2F"))
            holder.tvStatus.setBackgroundColor(Color.parseColor("#FFEBEE"))
        } else {
            holder.tvEmoji.text = "✅"
            holder.tvStatus.setTextColor(Color.parseColor("#E65100"))
            holder.tvStatus.setBackgroundColor(Color.parseColor("#FFF3E0"))
        }
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = list.size
<<<<<<< HEAD
}

=======
}
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
