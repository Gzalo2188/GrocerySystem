package com.groceryapp

class Product(val id: String, val name: String, val quantity: Int, val price: Double) {

    constructor() : this("", "",0, 0.0){

    }
}