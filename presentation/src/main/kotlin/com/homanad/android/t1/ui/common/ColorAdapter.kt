package com.homanad.android.t1.ui.common

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.homanad.android.common.extensions.context.themeColor
import com.homanad.android.common.utilities.createGradientDrawable
import com.homanad.android.t1.R
import com.homanad.android.t1.common.getColors
import com.homanad.android.t1.common.toIntColor

class ColorAdapter(
    context: Context
//    private val listener: (themeColor: ThemeColor) -> Unit
) : RecyclerView.Adapter<ColorAdapter.ItemHolder>() {

    private val themeColors: List<String> = getColors(context)

    private var selectedPos = 0

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val context = view.context
        private val imageColor = view.findViewById<AppCompatImageView>(R.id.view_color)
        private val imageSelected = view.findViewById<AppCompatImageView>(R.id.view_selected)

        fun bind(themeColor: String) {
            imageColor.setImageDrawable(
                createGradientDrawable(
                    themeColor.toIntColor(),
                    themeColor.toIntColor(),
                    GradientDrawable.OVAL,
                    GradientDrawable.Orientation.BR_TL
                )
            )
            if (selectedPos == adapterPosition) {
                imageSelected.setImageDrawable(
                    createGradientDrawable(
                        context.themeColor(R.attr.colorSecondary),
                        context.themeColor(R.attr.colorOnSecondary),
                        GradientDrawable.OVAL,
                        GradientDrawable.Orientation.BL_TR
                    )
                )
                imageSelected.visibility = View.VISIBLE
            } else {
                imageSelected.visibility = View.GONE
            }
            imageColor.setOnClickListener {
//                listener(themeColor)
                setSelectedPos(adapterPosition)
            }
        }
    }

    fun getSelectedColor(): String {
        return themeColors[selectedPos]
    }

    fun getSelectedPosition(): Int {
        return selectedPos
    }

    fun setSelectedPos(position: Int) {
        notifyItemChanged(selectedPos)
        selectedPos = position
        notifyItemChanged(selectedPos)
    }

    fun setSelectedColor(themeColor: String) {
        notifyItemChanged(selectedPos)
//        selectedPos = themeColors.indexOf(themeColor)
        themeColors.forEachIndexed { index, color ->
            if (color == themeColor) {
                selectedPos = index
                notifyItemChanged(selectedPos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return themeColors.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(themeColors[position])
    }
}