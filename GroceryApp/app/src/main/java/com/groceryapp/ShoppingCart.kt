package com.groceryapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_shopping_cart.*
import kotlinx.android.synthetic.main.activity_payments.*
import kotlinx.android.synthetic.main.activity_shopping_portal.*


class ShoppingCart : AppCompatActivity(){

    lateinit var  products: MutableList<Product>
    lateinit var displayList:MutableList<Product>
    companion object{
        var  cartItems: MutableList<Product> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        val actionBar = supportActionBar
        actionBar!!.title = "Shopping Cart"

        //products = ShoppingPortal.products
        displayList = mutableListOf()
        displayList.addAll(cartItems)

        var sum: Double = 0.0
        for(p in cartItems){
            sum += p.price * p.quantity
        }

        val str = "Total: $%.2f".format(sum)
        totalPayment.text = str

        cartList.layoutManager = LinearLayoutManager(this@ShoppingCart)
        cartList.adapter = CartAdapter(displayList, applicationContext, object : CartAdapter.OnTotalChangeListener{
            override fun onTotalChange(total: String) {
                totalPayment.text = total
            }
        })

        checkButton.setOnClickListener {
            startActivity(Intent(this, Payment::class.java))
        }
    }




}


