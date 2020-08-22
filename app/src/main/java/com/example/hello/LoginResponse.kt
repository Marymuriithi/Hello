package com.example.hello

class LoginResponse {


    data class LoginResponse(
            @SerializedName("access_token") var accessToken: String,
            @SerializedName("message") var message: String
    )

}
