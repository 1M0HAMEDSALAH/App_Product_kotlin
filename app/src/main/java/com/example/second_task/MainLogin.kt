package com.example.second_task

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room

class MainLogin: AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        var mydata = appDb.getRoomDb(this)
        var my_fun = mydata.getDaoFun()

        var edEmail=findViewById<EditText>(R.id.email_login)
        var edpasword=findViewById<EditText>(R.id.password_login)
        var btnlog =findViewById<Button>(R.id.login_btn)
        btnlog.setOnClickListener{
            var edEmailText=edEmail.text.toString()
            var edpaswordText=edpasword.text.toString()


            if (edEmailText.trim()==""||edpaswordText.trim()==""){
                Toast.makeText(this,"The Email Or Password Must Not Be Empty",Toast.LENGTH_SHORT).show()

            }else{
                var exit=true
                var old_data = my_fun.getUsers()
                for(p in old_data){
                    if(p.email==edEmailText&& p.password==edpaswordText){
                        exit=false
                        Data.LoggedInUser.name=p.name
                        Data.LoggedInUser.email=p.email
                        Data.LoggedInUser.password=p.password
                        Data.LoggedInUser.country=p.country
                        Data.LoggedInUser.role=p.role
                        if(p.email== edEmailText && p.password == edpaswordText ){
                            startActivity(Intent(this , Home_Retrofit::class.java))
                            break;
                        }else {
                            Toast.makeText(this,"Their Is no User Same That :)" ,Toast.LENGTH_SHORT ).show()
                        }
                    }
                }
                if(exit==true){
                    Toast.makeText(this,"Not found",Toast.LENGTH_SHORT).show()
                }
            }

        }

        var acc =findViewById<TextView>(R.id.donthaveacc)
        acc.setOnClickListener{
            startActivity(Intent(this, Mainsginup::class.java))
        }

    }

}


