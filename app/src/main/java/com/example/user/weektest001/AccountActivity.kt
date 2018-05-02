package com.example.user.weektest001

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AccountActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        var regi_id :EditText = findViewById(R.id.regi_id)
        var regi_email : EditText = findViewById(R.id.regi_email)
        var regi_pass1 : EditText = findViewById(R.id.refi_pass1)
        var regi_pass2: EditText = findViewById(R.id.regi_pass2)
        val btn_regi : Button = findViewById(R.id.btn_regi)
        var shf : SharedPreferences = getSharedPreferences("login",0)
        var edit :SharedPreferences.Editor = shf.edit()


        btn_regi.setOnClickListener {
            val id = regi_id.text.toString()
            val email = regi_email.text.toString()
            val pass1 = regi_pass1.text.toString()
            val pass2 = regi_pass2.text.toString()

            if((pass1==pass2)&&(email.contains('@')==true)){
               edit.putString("id",id)
               edit.putString("email",email)
               edit.putString("pass",pass1)
               edit.commit()

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this,"Register Error",Toast.LENGTH_SHORT).show()
                regi_email.setText("")
                regi_id.setText("")
                regi_pass1.setText("")
                regi_pass2.setText("")
            }


        }



    }
}
