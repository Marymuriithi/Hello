package CoursesAdapter.kt

import com.example.courses.Courses

    class CoursesResponse {

        data class CoursesResponse(
                @SerializedName("courses") var courses: List<Courses>
    }



}
