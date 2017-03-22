package co.hinge.reorder.gridview

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import co.hinge.reorder.R
import timber.log.Timber

class GridViewAdapter(val context: Context, val data: List<Int>) : BaseAdapter() {

    val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = when (convertView) {
            null -> {
                Timber.i("Inflating new photo layout at position $position")
                inflater.inflate(R.layout.photo, parent, false)
            }
            else -> {
                Timber.i("Found existing photo layout at position $position")
                convertView
            }
        }
        val photoImage = view.findViewById(R.id.photoImage) as ImageView?
        photoImage?.setImageDrawable(ContextCompat.getDrawable(context, getItem(position)))
        Timber.i("Setting image drawable at position $position")
        return view
    }

    override fun getItem(position: Int): Int {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}