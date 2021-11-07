package com.truebalance.app.base.view.adapter

/**
 * Created by Musharib Ali on 25/10/21.
 * ali.musharib1@gmail.com
 */
interface DiffComparable<T> {
    fun arryItemSame(item: T): Boolean
    fun arryContentsItemSame(item: T): Boolean
}