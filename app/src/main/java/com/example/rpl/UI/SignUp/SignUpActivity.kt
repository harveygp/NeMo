package com.example.rpl.UI.SignUp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.rpl.R
import com.example.rpl.UI.Login.LoginActivity
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_signup)

        register.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        })
    }
}