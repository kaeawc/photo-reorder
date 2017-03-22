package co.hinge.reorder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.hinge.reorder.gridview.GridViewActivity
import co.hinge.reorder.recyclerview.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridViewButton.setOnClickListener {
            routeTo(GridViewActivity::class.java)
        }

        recyclerViewButton.setOnClickListener {
            routeTo(RecyclerViewActivity::class.java)
        }
    }

    fun routeTo(clazz: Class<*>) {
        val intent = Intent(baseContext, clazz)
        startActivity(intent)
    }
}
