package com.brunafenali.fuelcalculator

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
        val btnProximo = findViewById<Button>(R.id.btnProximoPreco)

        val precoEuro = 1.50f  // O valor do euro fixo, como você mencionou.

        btnProximo.setOnClickListener {
            val preco = edtPreco.text.toString().toFloatOrNull()

            if (preco != null) {
                // Agora, calculamos o valor final em euro, sem exibir o valor de euro para o usuário.
                val precoEmEuro = preco * precoEuro  // Conversão do preço para euros

                // Envia o valor para a próxima atividade
                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra("preco", preco)  // Passando o preço em reais
                intent.putExtra("precoEmEuro", precoEmEuro)  // Passando o preço em euro para uso nos cálculos
                startActivity(intent)
            } else {
                edtPreco.error = "Por favor, insira um preço válido!"
            }
        }
    }
}
