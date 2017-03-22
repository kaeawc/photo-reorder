package co.hinge.reorder.recyclerview

import android.graphics.Point
import android.graphics.drawable.NinePatchDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ScrollView
import co.hinge.reorder.R
import com.h6ah4i.android.widget.advrecyclerview.animator.DraggableItemAnimator
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var dragDropManager: RecyclerViewDragDropManager
    lateinit var wrappedAdapter: RecyclerView.Adapter<*>
    lateinit var adapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(co.hinge.reorder.R.layout.activity_recycler_view)
        val display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        val width = point.x
        val height = point.y
        val columnCount = when {
            width > height -> 3
            else -> 2
        }

        val data = mutableListOf(
                android.R.color.holo_red_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light,
                android.R.color.holo_green_dark,
                android.R.color.holo_blue_dark
        )

        val photoLayoutManager = GridLayoutManager(baseContext, columnCount, GridLayoutManager.VERTICAL, false)

        // drag & drop manager
        dragDropManager = RecyclerViewDragDropManager()

        dragDropManager.setDraggingItemShadowDrawable(ContextCompat.getDrawable(baseContext, R.drawable.material_shadow_z3) as NinePatchDrawable)

        // Start dragging after long press
        dragDropManager.setInitiateOnLongPress(true)
        dragDropManager.setInitiateOnMove(false)
        dragDropManager.setLongPressTimeout(150)

        // setup dragging item effects (NOTE: DraggableItemAnimator is required)
        dragDropManager.dragStartItemAnimationDuration = 150
        dragDropManager.draggingItemAlpha = 1.0f
        dragDropManager.draggingItemScale = 1.2f
        dragDropManager.draggingItemRotation = 10.0f

        val itemAdapter = RecyclerGridAdapter(baseContext, data)
        adapter = itemAdapter

        wrappedAdapter = dragDropManager.createWrappedAdapter(itemAdapter)

        val animator = DraggableItemAnimator()
        recyclerView.layoutManager = photoLayoutManager
        recyclerView.adapter = wrappedAdapter
        recyclerView.itemAnimator = animator

        dragDropManager.attachRecyclerView(recyclerView)

        recyclerView.overScrollMode = ScrollView.OVER_SCROLL_NEVER
    }

    override fun onPause() {
        super.onPause()
        dragDropManager.cancelDrag()
    }

    override fun onDestroy() {
        dragDropManager.release()
        WrapperAdapterUtils.releaseAll(wrappedAdapter)
        super.onDestroy()
    }
}
