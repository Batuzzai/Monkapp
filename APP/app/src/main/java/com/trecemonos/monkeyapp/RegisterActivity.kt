package com.trecemonos.monkeyapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import java.net.URL

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        register_button2.setOnClickListener{
            conectarse("https://13monoscl.000webhostapp.com/bds/insertar_registro.php")
        }
    }

    private fun conectarse(URL : String){
        val stringRequest = object : StringRequest(Request.Method.POST, URL, Response.Listener { s ->
            // Your success code here
            Toast.makeText(applicationContext,"REGISTRADO SATISFACTORIAMENTE",Toast.LENGTH_SHORT).show();
        }, Response.ErrorListener { e ->
            // Your error code here
            Toast.makeText(applicationContext, "ERROR AL REGISTRAR",Toast.LENGTH_SHORT).show();
        }) {
            override fun getParams(): Map<String, String> {
                val parametros = HashMap<String,String>()
                parametros.put("nombres", nombres.text.toString());
                parametros.put("apellidos",apellidos.text.toString());
                parametros.put("contrasena",pswd.text.toString());
                parametros.put("correo",correo.text.toString());
                parametros.put("edad",edad.text.toString());

                return parametros
            }
        }
        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest);


    }
}
