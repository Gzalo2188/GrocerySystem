package com.groceryapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shopping_portal.*


class ShoppingPortal : AppCompatActivity() {

    lateinit var  listView: ListView

    lateinit var database: DatabaseReference
    lateinit var  products: MutableList<String>
    var displayList:MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_portal)
        cartFab.setOnClickListener{
            startActivity(Intent(this, ShoppingCart::class.java))
        }

        products = mutableListOf()
        val database = FirebaseDatabase.getInstance().getReference("Products")

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

        loadFirebase()
        productList.layoutManager = LinearLayoutManager(this@ShoppingPortal)
        productList.adapter = ProductAdapter(displayList, this)
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
                            if(it.toLowerCase().contains(search)){
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
        products.add("Apple")
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

        displayList.addAll(products)

    }
}