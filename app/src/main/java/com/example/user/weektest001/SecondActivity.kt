package com.example.user.weektest001

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)
        setTitle("메인화면")
        
        val intent:Intent = getIntent()
        val id :String= intent.extras.getString("id")
        val pass :String = intent.extras.getString("pass")



        var text_id : TextView = findViewById(R.id.id)
        var text_id_value : TextView = findViewById(R.id.id_value)

        text_id_value.setText(id)
    }

}
