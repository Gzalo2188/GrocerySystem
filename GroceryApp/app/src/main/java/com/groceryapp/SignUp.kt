package com.groceryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.signup.*
import android.widget.Toast
import com.google.firebase.database.*

class SignUp : AppCompatActivity(){

    lateinit var users: ArrayList<User>
    lateinit var ref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)


        users = ArrayList<User>()

        ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {


                if(p0.exists()){
                    for(p in p0.children){
                        val localUser = p.getValue(User::class.java)
                        val tempUser : User = User(localUser!!.id, localUser!!.username, localUser!!.password)
                        users.add(tempUser)
                    }
                }
            }

        })


        // Registering an account to FireBase
        registerButton.setOnClickListener{
            if((password1.text.toString() == password2.text.toString()) && (username.text.toString() != "")){
                //This is where if the correct info was put in

                val ref = FirebaseDatabase.getInstance().getReference("Users")
                val userId = ref.push().key
                val tempUser : User = User(userId!!, username.text.toString(), password1.text.toString())

                ref.child(userId).setValue(tempUser)

                Toast.makeText(this, "Account created" , Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else if(password1.text.toString() != password2.text.toString()){
                Toast.makeText(this, "Passwords do not match" , Toast.LENGTH_SHORT).show()
            } else if (username.text.toString() == ""){
                Toast.makeText(this, "Not a valid username" , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Could not make account" , Toast.LENGTH_SHORT).show()
            }
        }

        goBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}