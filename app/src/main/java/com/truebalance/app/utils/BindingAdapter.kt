package com.truebalance.app.utils

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.truebalance.app.BuildConfig
import com.truebalance.app.R
import com.truebalance.app.base.view.adapter.BaseAdapterBinding
import com.truebalance.app.data.api.LoadingState
import java.text.SimpleDateFormat

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("isVisible")
fun View.setIsVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("isEmpty")
fun View.setEmptyText(message: String?) {
    this.visibility = if (TextUtils.isEmpty(message)) View.GONE else View.VISIBLE
}

@BindingAdapter("entity")
fun RecyclerView.setEntity(data: List<Any>?) {
    data?.let { (this.adapter as BaseAdapterBinding<Any>).setData(data) }

}

@BindingAdapter("dateTimeStamp")
fun AppCompatTextView.setDateTimeStamp(time: Long?) {
    var simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
    this.text = simpleDateFormat.format(time)

}

@BindingAdapter("resourceInt")
fun TextView.setTextView(resourceInt:Int){
    this.text = this.context.resources.getString(resourceInt)
}


@BindingAdapter("thumbnail")
fun ImageView.setImage(url: String?) {
    Glide.with(this.context)
        .load(BuildConfig.BASE_IMAGE_URL+url ?: "")
        .optionalCenterCrop()
        .placeholder(R.drawable.placeholder)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
        .into(this)

}

@BindingAdapter("thumbnailFull")
fun ImageView.setImageFull(url: String?) {
    Glide.with(this.context)
        .load(BuildConfig.BASE_IMAGE_URL+url ?: "")
        .placeholder(R.drawable.placeholder)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(10)))
        .into(this)

}

@BindingAdapter("isLoading")
fun ProgressBar.progressVisibility(loadingState: LoadingState?) {
    loadingState?.let {
        isVisible = when (it.status) {
            LoadingState.Status.RUNNING -> true
            LoadingState.Status.SUCCESS -> false
            LoadingState.Status.FAILED -> false
        }
    }
}




