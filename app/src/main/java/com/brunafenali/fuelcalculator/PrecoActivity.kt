package com.example.fuelcalculator.com.brunafenali.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preco)

        val edtPreco = findViewById<EditText>(R.id.edtPreco)
        val btnProximo = findViewById<Button>(R.id.btnProximo)

        btnProximo.setOnClickListener {
            val preco = edtPreco.text.toString().toFloatOrNull()
            if (preco != null) {
                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra("preco", preco)
                startActivity(intent)
            } else {
                edtPreco.error = "Insira um valor válido!"
            }
        }
    }
}

}
{
}