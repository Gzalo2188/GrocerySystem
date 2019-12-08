package com.groceryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_product.view.*

class ProductAdapter(items : MutableList<Product>, ctx: Context): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    private var list = items
    private var context = ctx

    var listener: ((item: Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
        return ViewHolder(view)*/
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_product, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name?.text = list[position].name

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        override fun onClick(v: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        val name = itemView.productText
    }




}
