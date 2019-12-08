package com.groceryapp

class User(val id: String, val username: String, val password: String) {
    constructor() : this("","","")
}