package com.example.sleepr

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class GraphActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        var sleepChart = findViewById<LineChart>(R.id.linechart)
        var sleepChartTitle = findViewById<TextView>(R.id.LineChartTitle)

        sleepChartTitle.setText("Sleep chart:")
        sleepChart.setDragEnabled(true)
        sleepChart.setScaleEnabled(true)

        val point1 = Entry(0f, 50f)  // on point/index 0, the data is 50
        val point2 = Entry(1f, 100f) // on point/index 1, the data is 100
        val point3 = Entry(2f, 75f)  // on point/index 2, the data is 75

        val EntryArray = arrayListOf<Entry>(point1, point2, point3)

        val lineDataSet = LineDataSet(EntryArray, "Sleep")
        lineDataSet.color = Color.BLUE
        lineDataSet.setDrawValues(false)
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT)

        var lineData = LineData(lineDataSet)

        sleepChart.setData(lineData)
    }
}
