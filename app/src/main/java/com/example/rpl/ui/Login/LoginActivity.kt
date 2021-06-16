package com.example.rpl.ui.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rpl.R
import com.example.rpl.ui.HomeActivity
import com.example.rpl.ui.SignUp.SignUpActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        val database = FirebaseDatabase.getInstance().getReference()

        SignIn.setOnClickListener(View.OnClickListener {
            var nameUser = Username.text.toString().trim()
            var pw = Password.text.toString().trim()

//            startActivity(Intent(this, MainActivity::class.java))

            if(nameUser.isEmpty() && pw.isEmpty()){
                Toast.makeText(this, "Please Input Your Data", Toast.LENGTH_SHORT).show()
            }else{
                database.addListenerForSingleValueEvent(object : ValueEventListener{
                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.hasChild("Data${nameUser}")){
                            if (pw.equals(snapshot.child("Data${nameUser}").child("password").value.toString())){
                                val changeActivity = Intent(this@LoginActivity, HomeActivity::class.java)
                                changeActivity.putExtra("username", nameUser)
                                startActivity(changeActivity)
                            }else{
                                Toast.makeText(baseContext, "Incorrect Password", Toast.LENGTH_SHORT).show()
                            }
                        }else{
                            Toast.makeText(baseContext, "Username Not Found\nGo Make An Account", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        })

        SignUp.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        })
    }
}