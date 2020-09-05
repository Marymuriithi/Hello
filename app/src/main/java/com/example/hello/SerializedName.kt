package com.example.hello

import android.os.Parcel
import android.os.Parcelable

data class Course(
        var courseId: String?,
        var courseName: String?,
        var courseCode: String?,
        var instructor: String?,
        var description: String?,
        Parcelable{
    constructor(parcel: Parcel) :(

            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    ) {
    }

    fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(courseId)
        parcel.writeString(courseName)
        parcel.writeString(courseCode)
        parcel.writeString(instructor)
        parcel.writeString(description)
    }

    fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Course> {
        override fun createFromParcel(parcel: Parcel): Course {
            return Course(parcel)
        }

        override fun newArray(size: Int): Array<Course?> {
            return arrayOfNulls(size)
        }
    }
}
@SerializedName("course_id") var courseId: String,
@SerializedName("course_name") var courseName: String,
@SerializedName("course_code") var courseCode: String,
@SerializedName("instructor") var instructor: String,
@SerializedName("description") var description: String
    get() = ""
    set(value) = TODO()
)
} 