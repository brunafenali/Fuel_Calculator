package com.brunafenali.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)

        btnIniciar.setOnClickListener {
            // Preço do combustível em Euro já definido no código, como exemplo
            val precoEuro = 1.5f // Exemplo do preço em Euro (pode ser alterado conforme necessário)

            val intent = Intent(this, PrecoActivity::class.java)
            intent.putExtra("precoEuro", precoEuro) // Passa o preço do combustível em Euro
            startActivity(intent)
        }
    }
}
