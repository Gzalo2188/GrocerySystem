package com.groceryapp
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_payments.*
import kotlinx.android.synthetic.main.activity_shopping_portal.*
import kotlinx.android.synthetic.main.signup.*

class Payment: AppCompatActivity() {
    lateinit var text1 : EditText
    lateinit var text2 : EditText
    lateinit var text3 : EditText
    lateinit var text4 : EditText
    lateinit var text5 : EditText
    private var flag: Boolean = false
    private var choice: Int = -1;
    private var paymentList: ArrayList<String> = ArrayList<String>()

    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        val actionBar = supportActionBar
        actionBar!!.title = "Payment"

        val ref = FirebaseDatabase.getInstance().getReference("Invoices")

        payButton.setOnClickListener{

            if(shipmentName.length() < 1 || shipmentHome.length() < 1 || shipmentCity.length() < 1 ||
                shipmentState.length() < 1 || shipmentZip.length() < 1 || shipmentEmail.length() < 1 ||
                shipmentPN.length() < 1 ){
                Toast.makeText(applicationContext,"Please fill out all the fields", Toast.LENGTH_SHORT).show()
            }
            if(choice < 1){
                Toast.makeText(applicationContext,"Please choose a payment method", Toast.LENGTH_SHORT).show()
            }
            if(choice == 0){
                if(text1.text.isNotEmpty() && text2.text.isNotEmpty() &&
                    text3.text.isNotEmpty() && text4.text.isNotEmpty()){
                    paymentList.add(text1.text.toString())
                    paymentList.add(text2.text.toString())
                    paymentList.add(text3.text.toString())
                    paymentList.add(text4.text.toString())

                    val invoiceId = ref.push().key
                    val tempInvoice : Invoice = Invoice(invoiceId!!, shipmentName.text.toString(),
                        shipmentHome.text.toString(), shipmentCity.text.toString(),
                        shipmentState.text.toString(), shipmentZip.text.toString(),
                        shipmentEmail.text.toString(), shipmentPN.text.toString(), paymentList , ShoppingCart.cartItems.toCollection(ArrayList<Product>()))
                    ref.child(invoiceId).setValue(tempInvoice)
                    startActivity(Intent(this, Shipped::class.java))
                }
                else{
                    Toast.makeText(applicationContext,"Please fill out all the fields for payment", Toast.LENGTH_SHORT).show()
                }
            }
            if(choice == 1){
                if(text1.text.isNotEmpty() && text2.text.isNotEmpty() &&
                    text3.text.isNotEmpty()){
                    paymentList.add(text1.text.toString())
                    paymentList.add(text2.text.toString())
                    paymentList.add(text3.text.toString())

                    val invoiceId = ref.push().key
                    val tempInvoice : Invoice = Invoice(invoiceId!!, shipmentName.text.toString(),
                        shipmentHome.text.toString(), shipmentCity.text.toString(),
                        shipmentState.text.toString(), shipmentZip.text.toString(),
                        shipmentEmail.text.toString(), shipmentPN.text.toString(), paymentList , ShoppingCart.cartItems.toCollection(ArrayList<Product>()))
                    ref.child(invoiceId).setValue(tempInvoice)
                    startActivity(Intent(this, Shipped::class.java))
                }
                else{
                    Toast.makeText(applicationContext,"Please fill out all the fields for payment", Toast.LENGTH_SHORT).show()
                }
            }
            if(choice == 2){
                if(text5.text.isNotEmpty()){
                    paymentList.add(text5.text.toString())

                    val invoiceId = ref.push().key
                    val tempInvoice : Invoice = Invoice(invoiceId!!, shipmentName.text.toString(),
                        shipmentHome.text.toString(), shipmentCity.text.toString(),
                        shipmentState.text.toString(), shipmentZip.text.toString(),
                        shipmentEmail.text.toString(), shipmentPN.text.toString(), paymentList , ShoppingCart.cartItems.toCollection(ArrayList<Product>()))
                    ref.child(invoiceId).setValue(tempInvoice)
                    startActivity(Intent(this, Shipped::class.java))
                }
                else{
                    Toast.makeText(applicationContext,"Please fill out all the fields for payment", Toast.LENGTH_SHORT).show()
                }
            }

        }


        paymentMethods.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { _, Id ->
            val radio: RadioButton = findViewById(Id)

            val index = paymentMethods.indexOfChild(radio)

            val editText1 = EditText(this)
            val editText2 = EditText(this)
            val editText3 = EditText(this)
            val editText4 = EditText(this)
            val editText5 = EditText(this)

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

                    text1 = editText1
                    text2 = editText2
                    text3 = editText3
                    text4 = editText4
                    choice = 0

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
                    text1 = editText1
                    text2 = editText2
                    text3 = editText3
                    choice = 1
                }
                2 ->{
                    if(root.childCount >= 1){
                        root.removeAllViewsInLayout()
                    }
                    editText5.setHint("Enter Gift Card Number")
                    root.addView(editText5)
                    text5 = editText5
                    choice = 2
                }
            }
            //Toast.makeText(applicationContext,"Clicked this button ${index}", Toast.LENGTH_SHORT).show()
            })
    }
}
