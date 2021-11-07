package com.truebalance.app.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.truebalance.app.navigate.AppNavigatorInterface
import javax.inject.Inject

/**
 * Created by Musharib Ali on 5/11/21.
 * ali.musharib1@gmail.com
 */
open abstract class BaseFragment<DB : ViewDataBinding>(@LayoutRes pLayoutId: Int) : Fragment(),
    BaseUI<DB> {

    open var layoutId = pLayoutId
    open lateinit var binding: DB
    open fun init() {}
    open fun onInject() {}

    @Inject
    lateinit var navigator: AppNavigatorInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModelSetup()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpActionBar()

    }

    override fun viewModelSetup() {

    }


    private fun setUpActionBar() {
        if (!::binding.isInitialized) return

    }


}