package co.hinge.reorder.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(co.hinge.reorder.R.layout.activity_recycler_view)

        val data = listOf(
                android.R.color.holo_red_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light,
                android.R.color.holo_green_dark,
                android.R.color.holo_blue_dark
        )

        val layoutManager = GridLayoutManager(baseContext, 2, GridLayoutManager.VERTICAL, false)

        // drag & drop manager
        val dragDropManager = RecyclerViewDragDropManager()

        // Start dragging after long press
        dragDropManager.setInitiateOnLongPress(true)
        dragDropManager.setInitiateOnMove(false)
        dragDropManager.setLongPressTimeout(750)

        // setup dragging item effects (NOTE: DraggableItemAnimator is required)
        dragDropManager.dragStartItemAnimationDuration = 250
        dragDropManager.draggingItemAlpha = 0.8f
        dragDropManager.draggingItemScale = 1.3f
        dragDropManager.draggingItemRotation = 15.0f

        val adapter = RecyclerGridAdapter(baseContext, data.toMutableList())

        val wrappedAdapter = dragDropManager.createWrappedAdapter(adapter)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = wrappedAdapter

        dragDropManager.attachRecyclerView(recyclerView)
    }
}
