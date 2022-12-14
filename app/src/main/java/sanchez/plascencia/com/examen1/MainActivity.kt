package sanchez.plascencia.com.examen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var resultado=0
    var textoOperacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generarOperacion()

        btnVerificar.setOnClickListener {
            if(etRespuesta.text.isNotEmpty()){
                verificarRespuesta()
            }else{
                m("Escribe una respuesta")
            }
        }
    }

    fun verificarRespuesta(){
        var i = Intent()
        if(etRespuesta.text.toString().toInt() == resultado){

            i = Intent(this, CorrectoActivity::class.java)
            i.putExtra("resultado", resultado)
            i.putExtra("operacion",textoOperacion)
        }else{

            i = Intent(this, ErrorActivity::class.java)
            i.putExtra("resultado", resultado)
            i.putExtra("operacion",textoOperacion)
        }
        startActivity(i)
        generarOperacion()
    }

    fun m(mensaje:String){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
    }


    fun generarOperacion(){

        etRespuesta.text.clear()

        val listaOperaciones = listOf("suma","resta","multi")

        val num1 = Random.nextInt(0,11)//generar números entre 0-10
        val num2 = Random.nextInt(0,11)//
        //asignar el texto de la operación a mi
        //textView (se llame como se llame)

        val operacionARealizar = listaOperaciones[Random.nextInt(0,3)]
        println(operacionARealizar);
        when(operacionARealizar){
            "suma"->{
                resultado = num1+num2
                textoOperacion = "$num1 + $num2 = ?"
            }
            "resta"->{
                resultado = num1-num2
                textoOperacion = "$num1 - $num2 = ?"
            }
            "multi"->{
                resultado = num1*num2
                textoOperacion = "$num1 x $num2 = ?"
            }
        }

        tvOperacion.text = textoOperacion



    }
}
