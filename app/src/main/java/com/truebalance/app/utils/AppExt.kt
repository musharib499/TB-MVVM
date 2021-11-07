package com.truebalance.app.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */


fun Fragment.toast(message: String?) {
    message?.let {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
}

fun Activity.toast(message: String?) {
    message?.let {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}