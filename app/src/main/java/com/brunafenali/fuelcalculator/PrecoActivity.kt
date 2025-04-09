package com.brunafenali.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preco)  // Confirme que o nome do XML está correto!

        val edtPreco = findViewById<EditText>(R.id.edtPreco)  // Confirme se esse ID está no XML
        val btnProximo = findViewById<Button>(R.id.btnProximoPreco) // O ID do botão no XML é "btnProximoPreco"

        btnProximo.setOnClickListener {
            val preco = edtPreco.text.toString()

            // Verifica se o campo não está vazio e se o valor é válido (com 1 ou 2 casas decimais)
            if (preco.isNotEmpty() && preco.matches(Regex("^[0-9]+([.][0-9]{1,2})?\$"))) {
                val precoFloat = preco.toFloat()
                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra("preco", precoFloat)
                startActivity(intent)
            } else {
                edtPreco.error = "Insira um valor válido (ex: 5.79)"
            }
        }
    }
}
