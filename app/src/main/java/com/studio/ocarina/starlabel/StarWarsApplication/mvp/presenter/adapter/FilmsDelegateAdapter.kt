package com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.studio.ocarina.starlabel.R
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.ext.inflate
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models.Films
import kotlinx.android.synthetic.main.sw_viewholder.view.*

class FilmsDelegateAdapter(val viewActions: OnViewSelectedListener): ViewTypeDelegateAdapter {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as FilmsViewHolder
        holder.bind(item as Films)
    }

    override fun onCreateViewHolder(parent: ViewGroup):
            RecyclerView.ViewHolder = FilmsViewHolder(parent)

    inner class FilmsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
            parent.inflate(R.layout.sw_viewholder)){
         fun bind(item: Films) = with(itemView) {
             vh_title.text = item.title
             vh_name.text = item.director
             vh_description.text = item.openingCrawl
             super.itemView.setOnClickListener { viewActions.onItemSelected(item.url) }
        }
    }

}