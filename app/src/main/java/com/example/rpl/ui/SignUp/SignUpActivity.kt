package com.example.rpl.ui.SignUp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rpl.R
import com.example.rpl.ui.Login.LoginActivity
import com.example.rpl.ui.RegisterActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_signup)
        val database = FirebaseDatabase.getInstance().getReference()

        register.setOnClickListener(View.OnClickListener {
            if (firstName.text.toString().isEmpty() && lastName.text.toString().isEmpty() && email.text.toString().isEmpty() && username.text.toString().isEmpty() && password.text.toString().isEmpty()){
                Toast.makeText(baseContext, "There's Empty Data", Toast.LENGTH_SHORT).show()
            }else{
                var name = "${firstName.text} ${lastName.text}"
                database.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.hasChild("Data${username.text}")){
                            Toast.makeText(baseContext, "Username Taken", Toast.LENGTH_SHORT).show()
                        }else{
                            if(confirmPassword.text.toString().equals(password.text.toString())){
                                database.child("Data${username.text.toString()}").setValue(RegisterActivity(name, email.text.toString(), username.text.toString(), password.text.toString()))
                                    .addOnSuccessListener {
                                        Toast.makeText(baseContext, "Account Saved", Toast.LENGTH_SHORT).show()
                                        startActivity(Intent(baseContext, LoginActivity::class.java))
                                        finish()
                                    }
                            }else{
                                Toast.makeText(baseContext, "Password not Sync", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        })
    }
}