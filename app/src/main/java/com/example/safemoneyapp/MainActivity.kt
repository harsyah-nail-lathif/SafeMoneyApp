package com.example.safemoneyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtGaji : EditText
    private lateinit var tvTabung: TextView
    private lateinit var tvZakat : TextView
    private lateinit var btnHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtGaji = findViewById(R.id.edt_gaji)
        tvTabung = findViewById(R.id.tv_tabung)
        tvZakat = findViewById(R.id.tv_zakat)
        btnHitung = findViewById(R.id.btn_count)
        btnHitung.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_count){
            val gaji = edtGaji.text.toString().trim()
            var isEmptyField = false
            when{
                gaji.isEmpty()->{
                    Toast.makeText(this, "Silahkan isi gajimu", Toast.LENGTH_SHORT).show()
                }
            }
            if (!isEmptyField){
                val sedekah = gaji.toDouble() * 0.025
                tvZakat.text = sedekah.toInt().toString()
                val tabung = (gaji.toDouble() - sedekah.toDouble()) * 0.25
                tvTabung.text = tabung.toInt().toString()
            }
        }
    }
}