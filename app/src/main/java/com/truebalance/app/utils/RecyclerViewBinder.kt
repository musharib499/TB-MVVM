package com.truebalance.app.utils

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.truebalance.app.base.view.adapter.DiffComparable

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@BindingAdapter("itemList", "itemLayoutId")
fun <VM : Any> RecyclerView.bindData(
    itemList: List<VM>?,
    layoutId: Int
) {
    bindData(itemList, layoutId, null)
}


@BindingAdapter("itemListComparable", "itemLayoutId")
fun <VM : DiffComparable<VM>> RecyclerView.bindDiffComparable(
    itemList: List<VM>?,
    layoutId: Int
) {
    bindDiffComparable(itemList, layoutId, null)
}


@BindingAdapter("itemList", "itemLayoutId")
fun <VM : Any> RecyclerView.bindData(
    itemList: PagedList<VM>?,
    layoutId: Int
) {
    bindData(itemList, layoutId, null)
}


@BindingAdapter("itemListComparable", "itemLayoutId")
fun <VM : DiffComparable<VM>> RecyclerView.bindDiffComparable(
    itemList: PagedList<VM>?,
    layoutId: Int
) {
    bindDiffComparable(itemList, layoutId, null)
}


@BindingAdapter("itemDividerDrawable")
fun RecyclerView.setItemDivider(drawable: Drawable) {
    val layoutManager = layoutManager
    if (layoutManager !is LinearLayoutManager) {
        error("doesn't support $layoutManager")
    }

    DividerItemDecoration(context, layoutManager.orientation).apply {
        setDrawable(drawable)
    }.let { addItemDecoration(it) }
}

@BindingAdapter("usePagerSnapHelper")
fun RecyclerView.setItemDivider(use: Boolean) {
    PagerSnapHelper().attachToRecyclerView(this)
}