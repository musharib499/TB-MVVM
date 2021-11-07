package com.truebalance.app.base.view

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Created by Musharib Ali on 5/11/21.
 * ali.musharib1@gmail.com
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {
    val message  by lazy { MutableSharedFlow<String?>() }
    val messageWithString by lazy { MutableSharedFlow<Int>() }

}
