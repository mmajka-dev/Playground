package com.mmajka.hilt_prakt_retrofit.data.remote

import com.mmajka.hilt_prakt_retrofit.utils.Constants
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor {
    private var credentials = Credentials.basic(Constants.email, Constants.password)

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()

        return chain.proceed(request)
    }
}