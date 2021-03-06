package com.trecemonos.monkeyapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS

import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //DEBUG SKIP BOTON
        skip_button.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
        //REGISTER BOTON
        register_button.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        // LOGIN BOTON )

        login_button.setOnClickListener {
            validarUser("https://13monoscl.000webhostapp.com/bds/login.php")
        }
    }

    private fun validarUser(URL: String) {
        val stringRequest = object : StringRequest(Request.Method.POST, URL, Response.Listener { s ->
                // Your success code here



                if(s.contains("Bienvenido",true)){
                        showProgress(true)
                        Toast.makeText(this@LoginActivity, s.toString(), Toast.LENGTH_SHORT).show()
                        val intent2 = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent2)
                        showProgress(false)

                }else{
                    showProgress(true)
                    Toast.makeText(this@LoginActivity, s.toString(), Toast.LENGTH_SHORT).show()
                    showProgress(false)
                }
            }, Response.ErrorListener { e ->
                // Your error code here
                Toast.makeText(this@LoginActivity, "ERROR AL CONECTAR AL SERVIDOR \n Intentelo de nuevo más tarde", Toast.LENGTH_LONG).show()

            }) {
            override fun getParams(): Map<String, String> {
                val parametros = HashMap<String,String>()
                parametros.put("nombre_usuario",usuariologin.text.toString())
                parametros.put("contrasena",password.text.toString())

                return parametros
            }


            }
        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }

    private fun isEmailValid(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length > 4
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime : Long = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

            login_form.visibility = if (show) View.GONE else View.VISIBLE
            login_form.animate()
                .setDuration(shortAnimTime)
                .alpha((if (show) 0 else 1).toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        login_form.visibility = if (show) View.GONE else View.VISIBLE
                    }
                })

            login_progress.visibility = if (show) View.VISIBLE else View.GONE
            login_progress.animate()
                .setDuration(shortAnimTime)
                .alpha((if (show) 1 else 0).toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        login_progress.visibility = if (show) View.VISIBLE else View.GONE
                    }
                })
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            login_progress.visibility = if (show) View.VISIBLE else View.GONE
            login_form.visibility = if (show) View.GONE else View.VISIBLE
        }
    }
}
