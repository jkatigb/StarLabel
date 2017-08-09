package com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by JK on 8/8/2017.
 */

class SWAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var items: ArrayList<ViewType>
    private lateinit var listener: OnViewSelectedListener
    //TODO ? or is it interface in the FilmsDelegate class?

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType(): Int = ViewTypeConstants.LOADING
    }
    init {
        delegateAdapters.put(ViewTypeConstants.LOADING, LoadingDelAdapter())
        delegateAdapters.put(ViewTypeConstants.FILMS, FilmsDelegateAdapter(listener) )
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])
    }

    fun addItem(i: List<ViewType>) {
        val initalPos = i.size - 1
        items.removeAt(initalPos)
        notifyItemRemoved(initalPos)
        items.addAll(i)
        items.add(loadingItem)
        notifyItemChanged(initalPos, i.size + 1)//to include the loading item
    }

    fun clearAndAddItem(i: List<ViewType>) {
        items.clear()
        val getLastPosition = if(items.lastIndex == -1) 0 else i.lastIndex
        notifyItemRangeRemoved(0, getLastPosition)

        items.addAll(i)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)

    }

    fun getItems(viewType: Int): List<ViewType> =
            items.filter {
                it.getViewType() == viewType
            }.toList()

}