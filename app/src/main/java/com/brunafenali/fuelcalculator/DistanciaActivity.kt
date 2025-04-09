package com.brunafenali.fuelcalculator

import com.brunafenali.fuelcalculator.ResultadoActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distancia)

        val edtDistancia = findViewById<EditText>(R.id.edtDistancia)
        val btnProximo = findViewById<Button>(R.id.btnCalcular)

        val preco = intent.getFloatExtra("preco", 0f)
        val consumo = intent.getFloatExtra("consumo", 0f)

        btnProximo.setOnClickListener {
            val distancia = edtDistancia.text.toString().toFloatOrNull()
            if (distancia != null) {
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("preco", preco)
                intent.putExtra("consumo", consumo)
                intent.putExtra("distancia", distancia)
                startActivity(intent)
            } else {
                edtDistancia.error = "Insira uma distância válida!"
            }
        }
    }
}
