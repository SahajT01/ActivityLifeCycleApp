package com.example.activitylifecycleapp


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity

class ActivityB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        findViewById<View>(R.id.finishBButton).setOnClickListener {
            finish()
        }
    }
}