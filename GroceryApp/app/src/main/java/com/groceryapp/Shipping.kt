package com.groceryapp
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.shipping.*
import kotlinx.android.synthetic.main.activity_payments.*

class Shipping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shipping)

        homeButton3.setOnClickListener {
            startActivity(Intent(this, ShoppingPortal::class.java))
        }

        paymentButton.setOnClickListener {
            startActivity(Intent(this, Payment::class.java))
        }
    }
   // Button button = (Button) findViewById(R.id.paymentButton);
    //button.setOnClickListener(onClickListener);

}
