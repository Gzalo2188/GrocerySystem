package com.groceryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.signup.*
import android.widget.Toast

class SignUp : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        // Registering an account to FireBase
        registerButton.setOnClickListener{
            if((password1.text.toString() == password2.text.toString()) && (username.text.toString() != "")){
                //This is where if the correct info was put in
                val tempUser : User = User("nezuko-chan", username.text.toString(), password1.text.toString())
                Toast.makeText(this, "Account Created" , Toast.LENGTH_SHORT).show()
            } else if(password1.text.toString() != password2.text.toString()){
                Toast.makeText(this, "Passwords do not match" , Toast.LENGTH_SHORT).show()
            } else if (username.text.toString() == ""){
                Toast.makeText(this, "Not a valid UserName" , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Could not make Account" , Toast.LENGTH_SHORT).show()
            }
        }

    }
}