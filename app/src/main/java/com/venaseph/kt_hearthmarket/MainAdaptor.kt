package com.venaseph.kt_hearthmarket

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cardimg_row.view.*

/**
 * Created by cpera on 12/26/2017.
 */

class MainAdapter(val cardFeed: CardFeed) : RecyclerView.Adapter<CustomViewHolder>() {

    // numberOfItems
    override fun getItemCount(): Int {
        return cardFeed.Basic.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        //return View/Cell inside this method
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardimg_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        //grab stuff from your API Object Model to populate view
        val card = cardFeed.Basic.get(position)

        holder?.view?.titleView?.text = card.name
        holder?.view?.infoView?.text = card.text
        holder?.view?.flavorView?.text = """ "${card.flavor}" """

    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}