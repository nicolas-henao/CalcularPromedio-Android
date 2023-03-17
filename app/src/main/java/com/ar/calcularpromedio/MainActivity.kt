package com.ar.calcularpromedio

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var ingresarNombre: EditText? = null
    var ingresarMateria: EditText? = null
    var ingresarNota1: EditText? = null
    var ingresarNota2: EditText? = null
    var ingresarNota3: EditText? = null
    var txtResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ingresarNombre = findViewById(R.id.ingNombre)
        ingresarMateria = findViewById(R.id.ingMateria)
        ingresarNota1 = findViewById(R.id.ingNota1)
        ingresarNota2 = findViewById(R.id.ingNota2)
        ingresarNota3 = findViewById(R.id.ingNota3)
        txtResult = findViewById(R.id.textResult)

        val btnMostrar: Button = findViewById(R.id.btnMostrar)
        btnMostrar.setOnClickListener{onClick(1)}

        val btnEnviar: Button = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener{onClick(2)}

    }

    private fun onClick(boton: Int) {
        var result =""

        when (boton){
            1 -> {

                val nombre:String = ingresarNombre!!.text.toString()
                val materia:String = ingresarMateria!!.text.toString()
                val nota1:Double = ingresarNota1!!.text.toString().toDouble()
                val nota2:Double = ingresarNota2!!.text.toString().toDouble()
                val nota3:Double = ingresarNota3!!.text.toString().toDouble()

                var promedio: Double = (nota1 + nota2 + nota3)/3
                val roundoProm = String.format("%.1f", promedio)

                if (nota1 > 5 || nota1 < 0 || nota2 > 5 || nota2 < 0 || nota3 > 5 || nota3 < 0) {

                    result = "El rango de las notas debe estar entre 0 y 5"
                    txtResult!!.setTextColor(Color.RED)

                }  else if (promedio >= 3.5) {
                    result = " Nombre: ${nombre} \n Materia: ${materia} \n Promedio: ${roundoProm} \n !APROBO LA MATERIA!"
                    txtResult!!.setTextColor(Color.GREEN)

                } else {

                    result = " Nombre: ${nombre} \n Materia: ${materia} \n Promedio: ${roundoProm} \n !REPROBO LA MATERIA!"
                    txtResult!!.setTextColor(Color.RED)

                }

                txtResult?.text = result

            }

            2 -> {

                val intent = Intent(this, ActivityMessage::class.java)
                val miBundle:Bundle=Bundle()
                miBundle.putString("Result", txtResult!!.text.toString())
                intent.putExtras(miBundle)
                startActivity(intent)

            }

        }

    }
}