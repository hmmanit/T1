package com.homanad.android.t1.ui.feature.home.page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.t1.R

class HomeBoardAdapter : RecyclerView.Adapter<HomeBoardAdapter.ItemHolder>() {

    private var boards = listOf<BoardAndTasks>()

    fun setBoards(boards: List<BoardAndTasks>) {
        val diffCallback = DiffCallback(this.boards, boards)
        this.boards = boards
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val icon = view.findViewById<ShapeableImageView>(R.id.icon)
        private val textBoardName = view.findViewById<AppCompatTextView>(R.id.text_board_name)
        private val textNumber = view.findViewById<AppCompatTextView>(R.id.text_number)

        fun bind(board: BoardAndTasks) {
            textBoardName.text = board.board.boardTitle
            textNumber.text = board.tasks.size.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_board, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(boards[position])
    }

    override fun getItemCount(): Int {
        return boards.size
    }
}