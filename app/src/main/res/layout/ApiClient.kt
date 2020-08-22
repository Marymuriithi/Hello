package layout
import com.example.hello.Builder
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST




object ApiClient {
        var client = Builder().build()

        var retrofit = courseActivity.Builder()
                .baseUrl("https://courses-service.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        fun <T> buildService(service: Class<T>): T {
            return retrofit.create(service)
        }

        fun loginStudent(requestBody: Any): Any {


        }
    }