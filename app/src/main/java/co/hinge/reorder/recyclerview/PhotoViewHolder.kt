package co.hinge.reorder.recyclerview

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import co.hinge.reorder.R

class PhotoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bindData(context: Context, @DrawableRes drawable: Int) {
        val photoImage = view.findViewById(R.id.photoImage) as ImageView?
        photoImage?.setImageDrawable(ContextCompat.getDrawable(context, drawable))
    }
}
