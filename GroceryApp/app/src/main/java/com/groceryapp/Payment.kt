package com.groceryapp
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlinx.android.synthetic.main.activity_payments.*
import kotlinx.android.synthetic.main.activity_shopping_portal.*

class Payment: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        val actionBar = supportActionBar
        actionBar!!.title = "Payment"


        payButton.setOnClickListener{
            
            //startActivity(Intent(this, ShoppingPortal::class.java))
        }


        paymentMethods.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { _, Id ->
            val radio: RadioButton = findViewById(Id)
            //var flag = false
            val editText1 = EditText(this)
            val editText2 = EditText(this)
            val editText3 = EditText(this)
            val editText4 = EditText(this)
            val editText5 = EditText(this)
            val index = paymentMethods.indexOfChild(radio)

            when(index){
                0 -> {
                    if(root.childCount >= 1 ){
                        root.removeAllViewsInLayout()
                    }
                    editText1.setHint("Enter Name on Card")
                    root.addView(editText1)
                    editText2.setHint("Enter Card Number")
                    root.addView(editText2)
                    editText3.setHint("Enter CVV")
                    root.addView(editText3)
                    editText4.setHint("Enter Expiration Date")
                    root.addView(editText4)

                }
                1 -> {
                    if(root.childCount >= 1){
                        root.removeAllViewsInLayout()
                    }
                    editText1.setHint("Enter Name on Check")
                    root.addView(editText1)
                    editText2.setHint("Enter Routing Number")
                    root.addView(editText2)
                    editText3.setHint("Enter Account Number")
                    root.addView(editText3)
                }
                2 ->{
                    if(root.childCount >= 1){
                        root.removeAllViewsInLayout()
                    }
                    editText5.setHint("Enter Gift Card Number")
                    root.addView(editText5)
                }
            }
            //Toast.makeText(applicationContext,"Clicked this button ${index}", Toast.LENGTH_SHORT).show()
            })

    }
}
