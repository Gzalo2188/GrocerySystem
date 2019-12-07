package com.groceryapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_portal.*

class ShoppingPortal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_portal)

        cartFab.setOnClickListener{
            startActivity(Intent(this, ShoppingCart::class.java))
        }
    }
}