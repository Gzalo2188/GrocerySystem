package com.groceryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shipped.*
import kotlinx.android.synthetic.main.signup.*

class Shipped : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipped)

        goBackFAB.setOnClickListener{
            ShoppingCart.cartItems.clear()
            startActivity(Intent(this, ShoppingPortal::class.java))
        }
    }
}