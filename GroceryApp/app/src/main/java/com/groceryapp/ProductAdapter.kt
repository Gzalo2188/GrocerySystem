package com.groceryapp

import android.content.Context
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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

        protected var button: Button
        val qty: TextView
        val productName: TextView

        init {
            qty = itemView.findViewById(R.id.qtyBox) as TextView
            productName = itemView.findViewById(R.id.productText) as TextView
            button = itemView.findViewById(R.id.addButton) as Button

            button.setTag(R.integer.btn_add_view, itemView)
            button.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            if(v!!.id == button.id){
                if( ("" + qty.text).toIntOrNull() == null|| Integer.parseInt("" + qty.text!!) < 1){
                    Toast.makeText(this@ProductAdapter.context, "Nothing added to cart.", Toast.LENGTH_SHORT).show()
                    return
                }
                Toast.makeText(this@ProductAdapter.context, "" + ("" + qty.text).toIntOrNull() + " " +
                                productName.text + "(s) added to cart", Toast.LENGTH_LONG).show()
                qty.setText("")
            }
        }

        val name = itemView.productText
    }




}
