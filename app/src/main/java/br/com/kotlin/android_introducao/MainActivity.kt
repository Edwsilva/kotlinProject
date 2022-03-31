package br.com.kotlin.android_introducao

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)
        val btEnviar = findViewById<Button>(R.id.btEnviar)

        btEnviar.setOnClickListener {
//            "Ola, ${etNome.text.toString()}!"
            // checando se o etNome tem informação, se sim, mensagem de erro
            if (etNome.text.isNotBlank()) {
                // tvResultado.text =  "Ola, ${etNome.text}!"

                // Pegando string com parâmetros (android get strign with parameters
                // https://stackoverflow.com/questions/2397613/are-parameters-in-strings-xml-possible
                // preciso colocar etNome.text.toString() porque o parametro espera %1$s
                tvResultado.text = getString(R.string.hello_name, etNome.text.toString())
            } else {
//                 etNome.error = "Digite um nome"
                // Pegando um recurso de string e colocando no erro
                etNome.error = getString(R.string.type_your_name)
            }
        }
    }
}