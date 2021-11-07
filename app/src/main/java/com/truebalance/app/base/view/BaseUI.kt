package com.truebalance.app.base.view

import androidx.databinding.ViewDataBinding
import androidx.savedstate.SavedStateRegistryOwner

/**
 * Created by Musharib Ali on 5/11/21.
 * ali.musharib1@gmail.com
 */
interface BaseUI<T : ViewDataBinding> : SavedStateRegistryOwner {
    fun viewModelSetup()
}


