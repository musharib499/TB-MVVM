package com.truebalance.app.base.view.adapter

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Musharib Ali on 5/11/21.
 * ali.musharib1@gmail.com
 */
abstract class BaseRecyclerViewHolder<VM : Any>(
    private val binding: ViewDataBinding,
    private val lifecycleOwner: LifecycleOwner?
) : RecyclerView.ViewHolder(binding.root) {
    lateinit var viewModel: VM

    fun bind(viewModel: VM) {
        this.viewModel = viewModel
        binding.setVariable(viewModelId, viewModel)
        binding.lifecycleOwner = lifecycleOwner
        binding.executePendingBindings()
    }

    protected abstract val viewModelId: Int

}