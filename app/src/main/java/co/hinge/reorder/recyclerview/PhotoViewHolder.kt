package co.hinge.reorder.recyclerview

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import co.hinge.reorder.R
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder

class PhotoViewHolder(val view: View) : AbstractDraggableItemViewHolder(view) {

    var photoImage: ImageView? = view.findViewById(R.id.photoImage) as ImageView?
    var photoLabelText: TextView? = view.findViewById(R.id.photoLabelText) as TextView?

    fun bindData(context: Context, @DrawableRes drawable: Int, label: String) {
        photoImage?.setImageDrawable(ContextCompat.getDrawable(context, drawable))
        photoLabelText?.text = label
    }
}
