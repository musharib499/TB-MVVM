package com.truebalance.app.base.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.truebalance.app.navigate.AppNavigatorInterface
import javax.inject.Inject

/**
 * Created by Musharib Ali on 5/11/21.
 * ali.musharib1@gmail.com
 */
abstract class BaseActivity<DB : ViewDataBinding>(@LayoutRes pLayoutId: Int) : FragmentActivity(),
    BaseUI<DB> {
    private val layoutId: Int = pLayoutId
    open lateinit var binding: DB

    @Inject
    lateinit var navigator: AppNavigatorInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
    }

    override fun viewModelSetup() {
    }

    private fun setUpView() {
        if (layoutId == 0) return

        binding = DataBindingUtil.setContentView(this, layoutId) as DB
        binding.lifecycleOwner = this
        viewModelSetup()

    }

}