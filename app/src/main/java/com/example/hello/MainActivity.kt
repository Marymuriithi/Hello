package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import layout.ApiClient
import javax.security.auth.callback.Callback
import RegistrationActivity as RegistrationActivity1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegister.setOnClickListener{ it View!
            val intent = Intent(baseContext,

                    RegistrationActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener{ it View!
            var email =
                    etUserName.text.toString()
            var password =etPassword.text.toString()

            val requestBody = MultipartBody.Builder()
                    .setType(MultpartBody.FORM)
                    .addFormDataPart(name "email",email)
                    .addFormDataPart( name "password",password)
                    .build()

            loginUser(requestBody)


        }

    }
    fun loginUser(requestBody: RequestBody){
        val apiClent = ApiClient.buildService(ApiInterface::class.java)
        val loginCall = ApiClient.loginStudent(requestBody)


        loginCall.enqueue(object : Callback<LoginResponse>){
            overide fun onFailure(call:Call<LoginResponse>. t: Throwable){
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

        }
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    var accessToken = response.body()?.accessToken
                    var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.apply()
                    val intent = Intent(baseContext, CoursesActivity::class.java)
                    startActivity(intent)

                }
                else{
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
}
    }
}
