package com.brunafenali.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val preco = intent.getFloatExtra("preco", 0f)
        val consumo = intent.getFloatExtra("consumo", 0f)
        val distancia = intent.getFloatExtra("distancia", 0f)

        // Calcula o gasto final com o preço do combustível
        val gastoFinal = (distancia / consumo) * preco

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtResumo = findViewById<TextView>(R.id.txtResumo)
        val btnNovoCalculo = findViewById<Button>(R.id.btnNovoCalculo)

        // Exibe o gasto final em Euro (sem mencionar a moeda em todas as telas)
        txtResultado.text = "Gasto final: € %.2f".format(gastoFinal)
        txtResumo.text = "€ %.2f\n%.2f km/l\n%.2f km".format(preco, consumo, distancia)

        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
