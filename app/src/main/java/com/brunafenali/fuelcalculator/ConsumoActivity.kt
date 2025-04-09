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
        val btnProximo = findViewById<Button>(R.id.btnProximoConsumo)

        val preco = intent.getFloatExtra("preco", 0f)

        btnProximo.setOnClickListener {
            val consumo = edtConsumo.text.toString().toFloatOrNull()
            if (consumo != null) {
                val intent = Intent(this, DistanciaActivity::class.java)
                intent.putExtra("preco", preco)
                intent.putExtra("consumo", consumo)
                startActivity(intent)
            } else {
                edtConsumo.error = "Insira um valor válido!"
            }
        }
    }
}
