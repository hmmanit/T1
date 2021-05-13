package com.homanad.android.t1.ui.feature.home.page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import com.homanad.android.t1.R

class HomeTaskAdapter : RecyclerView.Adapter<HomeTaskAdapter.ItemHolder>() {

    private var tasks = listOf<TaskInBoard>()

    fun setTasks(tasks: List<TaskInBoard>) {
        val diffCallback = DiffCallback(this.tasks, tasks)
        this.tasks = tasks
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val icon = view.findViewById<AppCompatImageView>(R.id.icon)
        private val textBoardName = view.findViewById<AppCompatTextView>(R.id.text_board_name)
        private val textTaskName = view.findViewById<AppCompatTextView>(R.id.text_task_name)
        private val textStartTime = view.findViewById<AppCompatTextView>(R.id.text_start_time)
        private val textEndTime = view.findViewById<AppCompatTextView>(R.id.text_end_time)

        fun bind(task: TaskInBoard) {
            textBoardName.text = task.boardTitle
            textTaskName.text = task.taskTitle
            textStartTime.text = task.startTime.toString()
            textEndTime.text = task.endTime.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_task, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}