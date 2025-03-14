package com.f1d022094.tugas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputBerat: EditText = findViewById(R.id.inputBerat)
        val inputTinggi: EditText = findViewById(R.id.inputTinggi)
        val btnHitungBMI: Button = findViewById(R.id.btnHitungBMI)
        val hasilBMI: TextView = findViewById(R.id.hasilBMI)

        btnHitungBMI.setOnClickListener {
            val berat = inputBerat.text.toString().toDoubleOrNull()
            val tinggi = inputTinggi.text.toString().toDoubleOrNull()

            if (berat == null || tinggi == null || berat <= 0 || tinggi <= 0) {
                Toast.makeText(this, "Masukkan berat dan tinggi yang valid!", Toast.LENGTH_SHORT).show()
            } else {
                val tinggiMeter = tinggi / 100
                val bmi = berat / (tinggiMeter * tinggiMeter)

                val kategori = when {
                    bmi < 18.5 -> "Kurus"
                    bmi in 18.5..24.9 -> "Normal"
                    bmi in 25.0..29.9 -> "Gemuk"
                    else -> "Obesitas"
                }

                hasilBMI.text = "BMI: %.2f\nKategori: %s".format(bmi, kategori)
            }
        }
    }
}
