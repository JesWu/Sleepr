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
import java.io.File
import java.lang.Integer.parseInt

class GraphActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        var sleepChart = findViewById<LineChart>(R.id.linechart)
        var sleepChartTitle = findViewById<TextView>(R.id.LineChartTitle)

        sleepChartTitle.setText("Sleep chart:")
        sleepChart.setDragEnabled(true)
        sleepChart.setScaleEnabled(true)


        var file = File("" + getFilesDir() + "/Logs/Log.txt")
        var EntryArray = ArrayList<Entry>()
        file.forEachLine{

            var line = it.split(" ")
            var dateStart = line[2]
            var dateEnd = line[8]
            var timeStart = line[3].split(':')
            var timeEnd = line[9].split(':')
            var timeDiff = null

            //if the two days are the same
            if(dateStart == dateEnd){
                var hours = 0f
                hours += (parseInt(timeEnd[2]) - parseInt(timeStart[2]))
                /*
                hours += (parseInt(timeEnd[1]) - parseInt(timeStart[1])) / 60
                hours += (parseInt(timeEnd[2]) - parseInt(timeStart[2])) / (60 * 60)
                 */
                println("${timeEnd[2]} ${timeStart[2]} ${hours}")
                var entry = Entry(dateStart.toFloat(), hours)
                EntryArray.add(entry)
            }
        }

        /*
        var entry1 = Entry(0f, 0f)
        var entry2 = Entry(10f, 30f)
        var entry3 = Entry(20f, 20f)
        EntryArray = arrayListOf(entry1, entry2, entry3)
        */

        val lineDataSet = LineDataSet(EntryArray, "Hours")
        lineDataSet.color = Color.BLUE
        lineDataSet.setDrawValues(false)
        lineDataSet.axisDependency = YAxis.AxisDependency.LEFT

        var lineData = LineData(lineDataSet)

        sleepChart.data = lineData
        sleepChart.description.isEnabled = false
    }

}
