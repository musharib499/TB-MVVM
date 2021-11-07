package com.truebalance.app.utils

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.truebalance.app.base.view.adapter.BaseRecyclerViewAdapter
import com.truebalance.app.base.view.adapter.DiffComparable

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

fun <VM : DiffComparable<VM>> RecyclerView.bindDiffComparable(
    itemList: List<VM>?,
    layoutId: Int,
    lifecycleOwner: LifecycleOwner?
) {
    if (itemList == null) return

    if (layoutManager == null) {
        layoutManager = LinearLayoutManager(context)
    }

    @Suppress("UNCHECKED_CAST")
    val adapter = adapter as? BaseRecyclerViewAdapter<VM>
        ?: (object : BaseRecyclerViewAdapter<VM>(lifecycleOwner, getDiffUtil()) {
            override fun getItemLayoutId(position: Int) = layoutId
        }.also { adapter = it })

    adapter.submitList(itemList)
}

fun <VM : Any> RecyclerView.bindData(
    itemList: List<VM>?,
    layoutId: Int,
    lifecycleOwner: LifecycleOwner?
) {
    if (itemList == null) return

    if (layoutManager == null) {
        layoutManager = LinearLayoutManager(context)
    }

    @Suppress("UNCHECKED_CAST")
    val adapter = adapter as? BaseRecyclerViewAdapter<VM>
        ?: (object : BaseRecyclerViewAdapter<VM>(lifecycleOwner) {
            override fun getItemLayoutId(position: Int) = layoutId
        }.also { adapter = it })

    adapter.submitList(itemList)
}


private fun <VM : DiffComparable<VM>> getDiffUtil(): DiffUtil.ItemCallback<VM> =
    object : DiffUtil.ItemCallback<VM>() {
        override fun areItemsTheSame(oldItem: VM, newItem: VM): Boolean =
            oldItem.arryItemSame(newItem)

        override fun areContentsTheSame(oldItem: VM, newItem: VM): Boolean =
            oldItem.arryContentsItemSame(newItem)
    }