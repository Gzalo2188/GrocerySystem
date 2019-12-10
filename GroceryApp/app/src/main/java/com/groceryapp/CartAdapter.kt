package com.groceryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_shopping_cart.*
import kotlinx.android.synthetic.main.cart_product.view.*

class CartAdapter(items : MutableList<Product>, ctx: Context, onTotalChangeListener: OnTotalChangeListener) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private var list = items
    private var context = ctx
    private var totalListener = onTotalChangeListener

    var listener: ((item: Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cart_product, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.text = list[position].name
        holder.productPrice.text = "$" + list[position].price + " ea."
        holder.qty.text = "Qty: " + list[position].quantity

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{

        protected var button: Button
        val qty: TextView
        val productName: TextView
        val productPrice: TextView

        init {
            qty = view.findViewById(R.id.cartProductQty) as TextView
            productName = view.findViewById(R.id.cartProductName) as TextView
            productPrice = view.findViewById(R.id.cartProductPrice) as TextView
            button = view.findViewById(R.id.delButton) as Button

            button.setTag(R.integer.btn_add_view, view)
            button.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            if(v!!.id == button.id){
                var flag: Boolean = false
                var product: Product = Product()
                for(p in ShoppingCart.cartItems){
                    if(p.name == productName.text){
                        flag = true
                        product = p
                    }
                }

                if(flag){
                    ShoppingCart.cartItems.remove(product)
                    list.remove(product)
                    notifyItemRemoved(adapterPosition)
                    notifyItemRangeChanged(adapterPosition, list.size)
                    notifyDataSetChanged()

                    var sum: Double = 0.0
                    for(p in ShoppingCart.cartItems){
                        sum += p.price * p.quantity
                    }
                    val str = "Total: $%.2f".format(sum)
                    totalListener.onTotalChange(str)

                }
            }
        }

    }

    interface OnTotalChangeListener {
        fun onTotalChange(total: String)
    }
}

