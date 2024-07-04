package com.example.icmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvFinal : TextView = findViewById(R.id.textview_result)
        val tVclassificaçao : TextView = findViewById(R.id.textview_classificaçao)

        val result = intent.getFloatExtra("RESULT_FINAL",0.9f)

        tvFinal.text = result.toString()


       val imc = when{
           result < 18.5f -> "Abaio do peso"
           result in  18.5f .. 24.9f -> "Peso normal"
           result in 25.0f ..  29.9f -> "Sobrepeso"
           result in 30.0f .. 34.9f -> "obesidade classe I"
           result in 35.0f .. 39.9f -> "obesidade classe II"
           else -> "obesidade classe III"

       }

        tVclassificaçao.text = getString(R.string.massage_classificaçao, imc )
        
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    }
