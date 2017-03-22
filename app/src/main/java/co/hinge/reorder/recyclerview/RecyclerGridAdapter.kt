package co.hinge.reorder.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import co.hinge.reorder.recyclerview.PhotoViewHolder
import co.hinge.reorder.R
import java.lang.ref.WeakReference

class RecyclerGridAdapter(context: Context, val data: List<Int>) : RecyclerView.Adapter<PhotoViewHolder>() {

    val context: WeakReference<Context>? = WeakReference(context)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        if (position < 0 || position >= data.size) return
        val item = data[position]
        val context = context?.get() ?: return
        holder?.bindData(context, item)
    }
}
