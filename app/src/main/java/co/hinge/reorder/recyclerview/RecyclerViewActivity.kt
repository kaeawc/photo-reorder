package co.hinge.reorder.recyclerview

import android.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(co.hinge.reorder.R.layout.activity_recycler_view)

        val data = listOf(
                R.color.holo_red_dark,
                R.color.holo_orange_dark,
                R.color.holo_orange_light,
                R.color.holo_green_light,
                R.color.holo_green_dark,
                R.color.holo_blue_dark
        )

        val manager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = manager
        recyclerView.adapter = RecyclerGridAdapter(baseContext, data)
    }
}
