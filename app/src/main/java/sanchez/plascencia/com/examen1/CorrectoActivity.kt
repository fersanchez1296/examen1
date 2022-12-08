package sanchez.plascencia.com.examen1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_error.*

class CorrectoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correcto)

        val textoOperacion = intent.getStringExtra("operacion")
        val intResultado = intent.getIntExtra("resultado",0)


        tvOperacionError.text = textoOperacion
        tvRespuestaCorrecta.text = "$intResultado"
    }
}
