package com.groceryapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_cart.*
import kotlinx.android.synthetic.main.activity_payments.*


class ShoppingCart : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        homeButton.setOnClickListener {
            startActivity(Intent(this, ShoppingPortal::class.java))
        }

        checkButton.setOnClickListener {
            startActivity(Intent(this, Payment::class.java))
        }
    }


}


