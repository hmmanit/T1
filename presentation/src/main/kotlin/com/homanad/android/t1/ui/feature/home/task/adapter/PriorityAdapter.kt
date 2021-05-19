package com.homanad.android.t1.ui.feature.home.task.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.homanad.android.common.extensions.view.gone
import com.homanad.android.common.extensions.view.visible
import com.homanad.android.domain.entity.type.Priority
import com.homanad.android.t1.R
import com.homanad.android.t1.model.PriorityModel

class PriorityAdapter : RecyclerView.Adapter<PriorityAdapter.ItemHolder>() {

    private val priorities = listOf(
        PriorityModel(Priority.LOW.point, "Low", "#FF4CAF50"),
        PriorityModel(Priority.MEDIUM.point, "Medium", "#FFFFC107"),
        PriorityModel(Priority.HIGH.point, "High", "#F44336"),
    )

    private var selectedPos = -1

    private fun setSelection(position: Int) {
        val temp = selectedPos
        selectedPos = position
        notifyItemChanged(temp)
        notifyItemChanged(selectedPos)
    }

    fun getSelectedPriorityPoint(): Int = priorities[selectedPos].point

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val container = view.findViewById<MaterialCardView>(R.id.container)
        private val textTitle = view.findViewById<MaterialTextView>(R.id.text_title)
        private val iconSelected = view.findViewById<AppCompatImageView>(R.id.icon_selected)

        fun bind(priority: PriorityModel) {
            container.setCardBackgroundColor(Color.parseColor(priority.color))
            container.setOnClickListener {
                setSelection(adapterPosition)
            }
            textTitle.text = priority.title
            if (adapterPosition == selectedPos) iconSelected.visible()
            else iconSelected.gone()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_priority, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(priorities[position])
    }

    override fun getItemCount(): Int {
        return priorities.size
    }
}