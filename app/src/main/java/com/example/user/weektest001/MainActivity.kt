package com.example.user.weektest001

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_login : Button = findViewById(R.id.btn_login)
        val btn_new : Button = findViewById(R.id.btn_new)
        var text_id : EditText = findViewById(R.id.id)
        var text_pass : EditText = findViewById(R.id.password)

        val shf :SharedPreferences = getSharedPreferences("login", Context.MODE_WORLD_READABLE)

        btn_login.setOnClickListener{
            val id_value:String = text_id.text.toString()
            val pass_value :String= text_pass.text.toString()

            if ((id_value==shf.getString("id",""))&&(pass_value==shf.getString("pass",""))){
                var intent1 = Intent(this,SecondActivity::class.java)
                intent1.putExtra("id",id_value)
                intent1.putExtra("pass",pass_value)
                startActivity(intent1)
                onRestart()

            }else{
                text_id.setText("")
                text_pass.setText("")
                Toast.makeText(this,"ID / PASS ERROR",Toast.LENGTH_SHORT).show()
            }
        }

        btn_new.setOnClickListener{
            val intent2 : Intent = Intent(this,AccountActivity::class.java)
            startActivity(intent2)
        }

    }
}
