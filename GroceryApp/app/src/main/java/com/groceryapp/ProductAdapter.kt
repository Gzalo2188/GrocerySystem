package com.groceryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_product.view.*

class ProductAdapter(items : List<String>, ctx: Context): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    private var list = items
    private var context = ctx

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
        return ViewHolder(view)*/
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_product, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.name?.text = list[position]
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val name = view.productText
    }
}
