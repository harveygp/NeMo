package com.example.rpl.UI.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rpl.R
import com.example.rpl.UI.Home.HomeActivity
import com.example.rpl.UI.Home.HomeFragment
import com.example.rpl.UI.MainActivity
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

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
    }
}