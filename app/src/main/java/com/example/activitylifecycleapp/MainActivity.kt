package com.example.activitylifecycleapp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var threadCounter = 0
    private var onRestartCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val threadCounterText = findViewById<TextView>(R.id.threadCounterText)
        val onRestartCounterText = findViewById<TextView>(R.id.onRestartCounterText)

        threadCounter++
        updateThreadCounterText(threadCounterText)

        findViewById<View>(R.id.startActivityBButton).setOnClickListener {
            threadCounter += 5
            updateThreadCounterText(threadCounterText)
            startActivity(Intent(this, ActivityB::class.java))
        }

        findViewById<View>(R.id.startActivityCButton).setOnClickListener {
            threadCounter += 10
            updateThreadCounterText(threadCounterText)
            startActivity(Intent(this, ActivityC::class.java))
        }

        findViewById<View>(R.id.dialogButton).setOnClickListener {
            showDialog()
        }

        findViewById<View>(R.id.closeAppButton).setOnClickListener {
            finish()
        }

        updateThreadCounterText(threadCounterText)
        updateOnRestartCounterText(onRestartCounterText)
    }

    override fun onRestart() {
        super.onRestart()
        onRestartCounter++
        updateOnRestartCounterText(findViewById(R.id.onRestartCounterText))
    }

    private fun updateThreadCounterText(threadCounterText: TextView) {
        threadCounterText.text = "Thread Counter: $threadCounter"
    }

    private fun updateOnRestartCounterText(onRestartCounterText: TextView) {
        onRestartCounterText.text = "onRestart Counter: $onRestartCounter"
    }

    private fun showDialog() {
        val intent = Intent(this, DialogActivity::class.java)
        startActivity(intent)
    }
}