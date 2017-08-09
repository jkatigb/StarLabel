package com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: android.view.ViewGroup): android.support.v7.widget.RecyclerView.ViewHolder
    fun onBindViewHolder(holder: android.support.v7.widget.RecyclerView.ViewHolder, item: ViewType)
}