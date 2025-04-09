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

        val gastoFinal = (distancia / consumo) * preco

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtResumo = findViewById<TextView>(R.id.txtResumo)
        val btnNovoCalculo = findViewById<Button>(R.id.btnNovoCalculo)

        txtResultado.text = "Gasto final: R$ %.2f".format(gastoFinal)
        txtResumo.text = "Preço do combustível: R$ %.2f\nConsumo: %.2f km/l\nDistância: %.2f km".format(preco, consumo, distancia)

        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

