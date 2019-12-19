package com.trecemonos.monkeyapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            showProgress(false)
        }
    }

    private fun conectarse(URL : String){
        val stringRequest = object : StringRequest(Request.Method.POST, URL, Response.Listener { s ->
            // Your success code here

            Toast.makeText(applicationContext,s.toString(),Toast.LENGTH_LONG).show()
            showProgress(true)
        }, Response.ErrorListener { e ->
            // Your error code here
            showProgress(true)
            Toast.makeText(applicationContext, e.toString(),Toast.LENGTH_SHORT).show()
        }) {
            override fun getParams(): Map<String, String> {
                val parametros = HashMap<String,String>()
                parametros.put("nombre_apellido", nombres.text.toString())
                parametros.put("contrasena2",rptpswd.text.toString())
                parametros.put("contrasena",pswd.text.toString())
                parametros.put("correo",correo.text.toString())
                parametros.put("nombre_usuario",nick.text.toString())

                return parametros
            }
        }
        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)


    }

    private fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

            register_body_form.visibility = if (show) View.GONE else View.VISIBLE
            register_body_form.animate()
                .setDuration(shortAnimTime)
                .alpha((if (show) 0 else 1).toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        register_body_form.visibility = if (show) View.GONE else View.VISIBLE
                    }
                })

            register_progress.visibility = if (show) View.VISIBLE else View.GONE
            register_progress.animate()
                .setDuration(shortAnimTime)
                .alpha((if (show) 1 else 0).toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        register_progress.visibility = if (show) View.VISIBLE else View.GONE
                    }
                })
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            register_progress.visibility = if (show) View.VISIBLE else View.GONE
            register_body_form.visibility = if (show) View.GONE else View.VISIBLE
        }
    }
}
