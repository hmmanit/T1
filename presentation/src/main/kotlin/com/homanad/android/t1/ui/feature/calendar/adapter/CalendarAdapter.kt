package com.homanad.android.t1.ui.feature.calendar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.homanad.android.t1.R
import com.homanad.android.t1.common.generateFromToday
import com.homanad.android.t1.common.toDayModel

class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.ItemHolder>() {

    private val days = generateFromToday()

    private var selectedPosition = 10

    fun getSelectedPosition() = selectedPosition

    fun setSelection(position: Int) {
        val temp = selectedPosition
        selectedPosition = position
        notifyItemChanged(temp)
        notifyItemChanged(selectedPosition)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val root = view.rootView
        private val context = view.context
        private val textDayOfWeek = view.findViewById<MaterialTextView>(R.id.text_day_of_week)
        private val textDayOfMonth = view.findViewById<MaterialTextView>(R.id.text_day_of_month)

        fun bind(day: Long) {
            val dayModel = day.toDayModel()

            textDayOfWeek.text = dayModel.dayOfWeek
            textDayOfMonth.text = dayModel.dayOfMonth

            if (adapterPosition == selectedPosition) {
                root.background = ContextCompat.getDrawable(context, R.drawable.tab_calendar_indicator)
            } else root.background = null

            root.setOnClickListener {
                setSelection(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_calendar, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(days[position])
    }

    override fun getItemCount(): Int {
        return days.size
    }
}