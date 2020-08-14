package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
<RelativeLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">
<TextView
android:layout_centerHorizontal="true"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Popular Movies"
android:layout_margin="20dp"
android:id="@+id/title"
android:textSize="20sp"/>

<androidx.recyclerview.widget.RecyclerView
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:layout_margin="10dp"
android:layout_below="@+id/title"
android:id="@+id/recyclerView"/>

<ProgressBar
android:id="@+id/progress_bar"
style="@style/Widget.AppCompat.ProgressBar.Horizontal"
android:layout_width="match_parent"
android:layout_height="5dp"
android:scaleY="4"
android:indeterminateTint="@color/colorPrimary"
android:indeterminateBehavior="repeat"
android:indeterminate="true" />
</RelativeLayout>
