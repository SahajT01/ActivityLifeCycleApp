package com.example.activitylifecycleapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class ActivityC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        findViewById<View>(R.id.finishCButton).setOnClickListener {
            finish()
        }
    }
}