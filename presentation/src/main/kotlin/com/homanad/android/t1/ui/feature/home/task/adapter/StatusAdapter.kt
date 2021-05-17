package com.homanad.android.t1.ui.feature.home.task.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.homanad.android.domain.entity.type.Status
import com.homanad.android.t1.R
import com.homanad.android.t1.model.StatusModel

class StatusAdapter(context: Context) : BaseAdapter() {

    private val mInflater = LayoutInflater.from(context)

    private val statuses = listOf(
        StatusModel(Status.TODO.status, "To Do", "#FFFFC107"),
        StatusModel(Status.IN_PROGRESS.status, "In Progress", "#FF03A9F4"),
        StatusModel(Status.DONE.status, "Done", "#FF4CAF50"),
    )

    override fun getCount(): Int {
        return statuses.size
    }

    override fun getItem(position: Int): StatusModel {
        return statuses[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createItemView(position, parent)
    }

    private fun createItemView(position: Int, parent: ViewGroup?): View {
        val view = mInflater.inflate(R.layout.item_spinner_status, parent, false)

        val iconColor = view.findViewById<MaterialCardView>(R.id.icon_color)
        val textTitle = view.findViewById<MaterialTextView>(R.id.text_title)

        val status = getItem(position)
        iconColor.setCardBackgroundColor(Color.parseColor(status.color))
        textTitle.text = status.title

        return view
    }
}