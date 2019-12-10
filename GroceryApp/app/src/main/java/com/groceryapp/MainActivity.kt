package com.groceryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.widget.Toast
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {

    lateinit var users: ArrayList<User>
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        users = ArrayList<User>()

        ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {


                if(p0.exists()){
                    for(p in p0.children){
                        val localUser = p.getValue(User::class.java)
                        val tempUser : User = User(localUser!!.id, localUser.username, localUser.password)
                        users.add(tempUser)
                    }
                }
            }

        })
        loginButton.setOnClickListener{
            var flag = false
            for(user in users){
                if(user.username.toLowerCase() == ("" + usernameText.text).toLowerCase()){
                    if(user.password == "" + passwordText.text){
                        flag = true
                        startActivity(Intent(this, ShoppingPortal::class.java))
                    }
                    else{
                        Toast.makeText(this, "Invalid Password" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if(!flag) {
                Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show()
            }
        }

        signUp.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
        }

    }


}
