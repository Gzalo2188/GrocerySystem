package com.groceryapp

class Invoice(val id: String, val name: String, val home: String, val city: String,
              val state: String, val zip: String, val email: String, val phone: String, val payment: ArrayList<String>) {

    constructor() : this("", "", "", "", "", "", "", "", ArrayList<String>()){

    }
}