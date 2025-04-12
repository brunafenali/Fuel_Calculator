package com.brunafenali.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ConsumoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumo)

        val edtConsumo = findViewById<EditText>(R.id.edtConsumo)
        val btnProximoConsumo = findViewById<Button>(R.id.btnProximoConsumo)

        // Recebe o preço do combustível em Euro e o preço em moeda local
        val precoEuro = intent.getFloatExtra("precoEuro", 0f)
        val preco = intent.getFloatExtra("preco", 0f)

        btnProximoConsumo.setOnClickListener {
            val consumo = edtConsumo.text.toString().toFloatOrNull()

            if (consumo != null) {
                val intent = Intent(this, DistanciaActivity::class.java)
                intent.putExtra("precoEuro", precoEuro)
                intent.putExtra("preco", preco)
                intent.putExtra("consumo", consumo)
                startActivity(intent)
            } else {
                edtConsumo.error = "Por favor, insira um valor válido para consumo (ex: 12.5)"
            }
        }
    }
}
