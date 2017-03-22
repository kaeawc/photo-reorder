package co.hinge.reorder.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import co.hinge.reorder.R
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemConstants as Draggable
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange
import timber.log.Timber
import java.lang.ref.WeakReference

class RecyclerGridAdapter(context: Context, val data: MutableList<Int>) :
        RecyclerView.Adapter<PhotoViewHolder>(),
        DraggableItemAdapter<PhotoViewHolder> {

    var weakContext: WeakReference<Context>? = WeakReference(context)

    init {
        setHasStableIds(true)
    }

    override fun onCheckCanStartDrag(holder: PhotoViewHolder, position: Int, x: Int, y: Int): Boolean {
        return true
    }

    override fun onCheckCanDrop(draggingPosition: Int, dropPosition: Int): Boolean {
        return true
    }

    override fun onMoveItem(fromPosition: Int, toPosition: Int) {

        if (fromPosition == toPosition) {
            return Timber.e("Cannot move from $fromPosition to itself")
        }

        swap(fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onGetItemDraggableRange(holder: PhotoViewHolder, position: Int): ItemDraggableRange? {
        return null
    }

    fun swap(firstPosition: Int, secondPosition: Int) {
        val swap = data[firstPosition]
        data[firstPosition] = data[secondPosition]
        data[secondPosition] = swap
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        val value = data.size
        return value
    }

    override fun getItemId(position: Int): Long {
        return data[position].toLong()
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        if (position < 0 || position >= data.size) return
        val item = data[position]
        val context = weakContext?.get() ?: return
        holder.bindData(context, item)
    }
}
