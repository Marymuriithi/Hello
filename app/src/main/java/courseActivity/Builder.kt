package CoursesActivity.kt
    import CoursesAdapter.kt.CoursesResponse
    import android.os.Bundle
    import android.preference.PreferenceManager
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.example.hello.Course
    import com.example.hello.R
    import kotlinx.android.synthetic.main.activity_courses.*
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class CoursesActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_courses)
            var courseList = listOf<Course>(
                    Course("1", "Java", "AAID 104", "Rose Maina", "Create an app"),
                    Course("2", "Python", "IAFD 101", "James Maina", "Runs code"),
                    Course("3", "Data scince", "ACFID 102", "Anne Maina", "Taking Data"),
                    Course("4", "Android", "CFID 113", "John Maina", "Creating apps"),
                    Course("5", "Machine Learning", "FAID 114", "Bety Maina", "Learning program"),
                    Course("6", "Java Script", "SWID 104", "Purith Maina", "Debuging "),
                    Course("7", "Html", "AMZD 108", "Jeff Maina", "Create websites"),
                    Course("8", "Kotlin", "AAFG 107", "Micheal Maina", "Runing code"),
                    Course("9", "Django", "AFRID 102", "Monicah Maina", "Create an app"),
                    Course("10", "Network", "ASWID 113", "Winnie Maina", "Networking")

            )
            rvCourses.layoutManager = LinearLayoutManager(baseContext)
            rvCourses.adapter = CoursesAdapter(courseList)

            fetchCourses()
        }

        fun fetchCourses() {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
            val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

            val apiClient = ApiClient.buildService(ApiInterface::class.java)
            val coursesCall = apiClient.getCourses("Bearer " + accessToken)
            coursesCall.enqueue(object : Callback<CoursesResponse> {
                override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                        call: Call<CoursesResponse>,
                        response: Response<CoursesResponse>
                ) {
                    if (response.isSuccessful) {
                        var courseList = response.body()?.courses as List<Course>
                        var coursesAdapter = CoursesAdapter(courseList)
                        rvCourses.layoutManager = LinearLayoutManager(baseContext)
                        rvCourses.adapter = coursesAdapter
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                                .show()
                    }
                }
            })
        }
    }

}
class Builder {

}
