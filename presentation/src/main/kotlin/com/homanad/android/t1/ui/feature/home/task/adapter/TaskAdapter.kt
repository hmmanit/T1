package com.homanad.android.t1.ui.feature.home.task.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import com.homanad.android.t1.R
import com.homanad.android.t1.common.getPriorityByPoint
import com.homanad.android.t1.common.getStatusByStatus
import com.homanad.android.t1.common.toDateTimeWithNewLine

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.ItemHolder>() {

    //TODO need to create a full information Model
    private var tasks = listOf<TaskInBoard>()

    fun setTasks(tasks: List<TaskInBoard>) {
        val diffCallback = DiffCallback(this.tasks, tasks)
        this.tasks = tasks
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val viewIndicator = view.findViewById<View>(R.id.view_indicator)
        private val textTitle = view.findViewById<MaterialTextView>(R.id.text_title)
        private val textDescription = view.findViewById<MaterialTextView>(R.id.text_description)

        private val layoutPriority = view.findViewById<View>(R.id.layout_priority)
        private val containerPriority =
            layoutPriority.findViewById<MaterialCardView>(R.id.container_priority)
        private val textPriority = layoutPriority.findViewById<MaterialTextView>(R.id.text_title)

        private val layoutStatus = view.findViewById<View>(R.id.layout_status)
        private val iconColor = layoutStatus.findViewById<MaterialCardView>(R.id.icon_color)
        private val textStatus = layoutStatus.findViewById<MaterialTextView>(R.id.text_title)

        private val textStartTime = view.findViewById<MaterialTextView>(R.id.text_start_time)

        fun bind(task: TaskInBoard) {
            textTitle.text = task.taskTitle
            textDescription.text = task.taskDescription

            val priority = getPriorityByPoint(task.priority)
            containerPriority?.setCardBackgroundColor(Color.parseColor(priority.color))
            textPriority.text = priority.title

            val status = getStatusByStatus(task.status)
            iconColor.setCardBackgroundColor(Color.parseColor(status.color))
            textStatus.text = status.title

            textStartTime.text = task.startTime.toDateTimeWithNewLine()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}