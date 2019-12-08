package com.groceryapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shopping_portal.*


class ShoppingPortal : AppCompatActivity() {

    lateinit var  listView: ListView
    lateinit var ref: DatabaseReference
    lateinit var  products: MutableList<Product>
    var displayList:MutableList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_portal)
        cartFab.setOnClickListener{
            startActivity(Intent(this, ShoppingCart::class.java))
        }
        loadFirebase()
        productList.layoutManager = LinearLayoutManager(this@ShoppingPortal)

        //Toast.makeText(applicationContext, "Before the ref event.", Toast.LENGTH_SHORT).show()
        products = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("Products")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {


                if(p0.exists()){
                    products.clear()
                    for(p in p0.children){
                        val localProduct = p.getValue(Product::class.java)
                        products.add(localProduct!!)
                    }
                    displayList.addAll(products)
                    productList.adapter = ProductAdapter(displayList, applicationContext)
                }
            }

        })



/*        database.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    products.clear()
                    for(product in p0.children){
                        val tempProduct = product.getValue(Product::class.java)
                        d("Product from Database: ", product.getValue().toString())
                        d("Product Class: ", tempProduct!!.name + " " + tempProduct!!.quantity)
                        products.add(tempProduct!!)
                    }

                    for(product in products){
                        displayList.add(product.name)
                    }
                }
            }

        })*/

/*        productList.apply{
            layoutManager = LinearLayoutManager(this@ShoppingPortal)
            adapter = ProductAdapter(displayList, this.context)

        }*/


    }

   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        val searchItem = menu!!.findItem(R.id.menu_search)
        if(searchItem != null){
            val searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    displayList.clear()
                    if(newText!!.isNotEmpty()){
                        val search = newText.toLowerCase()
                        products.forEach {
                            if(it.name.toLowerCase().contains(search)){
                                displayList.add(it)
                            }
                        }
                    }else{
                        displayList.addAll(products)
                    }
                    productList.adapter?.notifyDataSetChanged()
                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    private fun loadFirebase(){


/*        products.add("Apple")
        products.add("Banana")
        products.add("Potato")
        products.add("Tomato")
        products.add("Egg")
        products.add("Chicken")
        products.add("Beef")
        products.add("Pork")
        products.add("Lettuce")
        products.add("Avocado")
        products.add("Turkey")
        products.add("Ham")
        products.add("Soda")
        products.add("Melon")
        products.add("Lime")
        products.add("Green Pepper")
        products.add("Yellow Pepper")

        displayList.addAll(products)*/

        //DO NOT FOR WHATEVER REASON UNCOMMENT THIS CODE, OTHERWISE THE DATABASE WILL GET CLUTTERED
/*      val ref = FirebaseDatabase.getInstance().getReference("Users")
        val productId = ref.push().key
        val product = User(productId!!,"placeholder", "placeholder")

        ref.child(productId).setValue(product)*/
    }
}