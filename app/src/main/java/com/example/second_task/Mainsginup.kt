package com.example.second_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class Mainsginup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainsginup)


        var mydata = appDb.getRoomDb(this)
        var my_fun = mydata.getDaoFun()

        var loginText = findViewById<TextView>(R.id.logintext)
        var edname = findViewById<EditText>(R.id.name)
        var edemail = findViewById<EditText>(R.id.email)
        var edpass = findViewById<EditText>(R.id.pass1)
        var edcoun = findViewById<Spinner>(R.id.country)
        var edrole = findViewById<Spinner>(R.id.rol)
        var edsign = findViewById<Button>(R.id.signup_btn)


        loginText.setOnClickListener{
            finish()
        }

        edsign.setOnClickListener{
            var textname = edname.text.toString()
            var textemail = edemail.text.toString()
            var textpass = edpass.text.toString()
            var textcountry = edcoun.selectedItem.toString()
            var textrole = edrole.selectedItem.toString()

            if (textname=="" || textemail =="" || textpass == ""){
                Toast.makeText(this," not valid ", Toast.LENGTH_SHORT).show()
            }else{
                var u = user(0,textname,textemail,textpass,textcountry,textrole)
                my_fun.addUser(u)
                finish()
            }


        }

    }
}

