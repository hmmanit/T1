package com.homanad.android.t1.ui.feature.home.page.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.t1.R
import com.homanad.android.t1.model.StatBoardModel

class ChartBoardAdapter : RecyclerView.Adapter<ChartBoardAdapter.ItemHolder>() {

    private var statBoards = listOf<StatBoardModel>()

    fun setStatBoards(statBoards: List<StatBoardModel>){
        val diffCallback = DiffCallback(this.statBoards, statBoards)
        this.statBoards = statBoards
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val pieChart = view.findViewById<PieChart>(R.id.pie_chart)

        fun bind(statBoard: StatBoardModel) {
//            pieChart.setUsePercentValues(true)
            pieChart.description.isEnabled = false
            pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

            pieChart.dragDecelerationFrictionCoef = 0.95f

//            pieChart.setCenterTextTypeface(tfLight)
            pieChart.centerText = statBoard.board.boardTitle

            pieChart.isDrawHoleEnabled = true
            pieChart.setHoleColor(Color.WHITE)

            pieChart.setTransparentCircleColor(Color.WHITE)
            pieChart.setTransparentCircleAlpha(110)

            pieChart.holeRadius = 58f
            pieChart.transparentCircleRadius = 61f

            pieChart.setDrawCenterText(true)
            pieChart.rotationAngle = 0f

            // enable rotation of the chart by touch
            // enable rotation of the chart by touch
            pieChart.isRotationEnabled = true
            pieChart.isHighlightPerTapEnabled = true

            // chart.setUnit(" €");
            // chart.setDrawUnitsInChart(true);

            // add a selection listener

            // chart.setUnit(" €");
            // chart.setDrawUnitsInChart(true);

            // add a selection listener
//            pieChart.setOnChartValueSelectedListener(this)
            pieChart.animateY(1400, Easing.EaseInOutQuad)

            // chart.spin(2000, 0, 360);
            val l: Legend = pieChart.legend
            l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
            l.orientation = Legend.LegendOrientation.VERTICAL
            l.setDrawInside(false)
            l.xEntrySpace = 7f
            l.yEntrySpace = 0f
            l.yOffset = 0f


            // entry label styling
            pieChart.setEntryLabelColor(Color.WHITE)
//            pieChart.setEntryLabelTypeface(tfRegular)
            pieChart.setEntryLabelTextSize(12f)

            pieChart.data = getData(pieChart.context, statBoard)

        }
    }

    private fun getData(context: Context, statBoard: StatBoardModel): PieData {
        val entries = ArrayList<PieEntry>()
        val colors = ArrayList<Int>()
        statBoard.statStatusModel.forEach {
            entries.add(
                PieEntry(
                    it.count.toFloat(),
                    statBoard.board.boardTitle,
                    ContextCompat.getDrawable(context, R.drawable.ic_home)
                )
            )

            colors.add(Color.BLUE)
        }

        val dataSet = PieDataSet(entries, "Election Results")

        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f
        dataSet.colors = colors

        //dataSet.setSelectionShift(0f);
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
//        data.setValueTypeface(tfLight)
        return data
//        chart.setData(data)
//
//        // undo all highlights
//
//        // undo all highlights
//        chart.highlightValues(null)
//
//        chart.invalidate()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chart_board, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(statBoards[position])
    }

    override fun getItemCount(): Int {
        return statBoards.size
    }
}