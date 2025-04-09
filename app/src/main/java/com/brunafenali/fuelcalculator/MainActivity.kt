package com.brunafenali.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Certifique-se que o layout XML está correto

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)

        btnIniciar.setOnClickListener {
            // Ao clicar no botão "Iniciar", navega para a tela de Preço do Combustível
            val intent = Intent(this, PrecoActivity::class.java)
            startActivity(intent)
        }
    }
}
