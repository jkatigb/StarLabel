package com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.studio.ocarina.starlabel.R
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.ext.inflate


class LoadingDelAdapter: ViewTypeDelegateAdapter {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        TODO("not implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup):
            RecyclerView.ViewHolder = LoadingViewHolder(parent)

    class LoadingViewHolder(parent:ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.drawable.abc_ic_ab_back_material))

}