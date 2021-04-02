package com.example.rpl.UI.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rpl.R
import com.example.rpl.UI.MainActivity
import com.example.rpl.UI.SignUp.SignUpActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        SignIn.setOnClickListener(View.OnClickListener {
            var name = Username.text.toString().trim()
            var pw = Password.text.toString().trim()

            if(name.equals("arpei") && pw.equals("nemo")){
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(this, "${name} , ${pw}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "SALAH JANCOK", Toast.LENGTH_SHORT).show()
            }
        })

        SignUp.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        })
    }
}