package com.ar.calcularpromedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityMessage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val txtResult2 = findViewById<TextView>(R.id.txtResult2)

        var miBundle:Bundle? = this.intent.extras

        if (miBundle != null) {

            txtResult2.text ="${miBundle.getString("Result")}"

        }

        val btnRegresar: Button = findViewById(R.id.btnRegresar)
        btnRegresar.setOnClickListener{onClick()}

    }

    private fun onClick() {
        finish()
    }

}