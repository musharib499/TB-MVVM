package com.truebalance.app.base.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.truebalance.app.R
import com.truebalance.app.navigate.AppNavigatorInterface
import javax.inject.Inject

/**
 * Created by Musharib Ali on 5/11/21.
 * ali.musharib1@gmail.com
 */
open abstract class BaseDialogFragment<DB : ViewDataBinding>(@LayoutRes pLayoutId: Int) :
    DialogFragment(), BaseUI<DB> {

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
        Log.d("testing1", "Base Fragment")
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
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
        if (!::binding.isInitialized) return

    }

    fun showDialog(manager: FragmentManager?, tag: String? = this.tag) {
        if (isVisible) dismissAllowingStateLoss()
        else {
            manager?.let { show(it, tag) }
        }
    }

}