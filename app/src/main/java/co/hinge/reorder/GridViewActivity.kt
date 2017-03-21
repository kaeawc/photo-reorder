package co.hinge.reorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class GridViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
                android.R.color.holo_red_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light,
                android.R.color.holo_green_dark,
                android.R.color.holo_blue_dark
        )
        gridView.adapter = GridViewAdapter(baseContext, data)
    }
}
