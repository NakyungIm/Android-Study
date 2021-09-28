package com.example.kotlinfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Setup application
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "OnCreate Function", Toast.LENGTH_LONG )
        Log.i("info", "OnCreate Function Executed!")
        
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart Function", Toast.LENGTH_LONG )
        Log.i("info", "OnStart Function Executed!")
    }

    override fun onResume() { // Load users data
        super.onResume()
        Toast.makeText(this, "OnResume Function", Toast.LENGTH_LONG )
        Log.i("info", "OnResume Function Executed!")
    }

    override fun onPause() { // Save users data
        super.onPause()
        Toast.makeText(this, "OnPause Function", Toast.LENGTH_LONG )
        Log.i("info", "OnPause Function Executed!")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "OnStop Function", Toast.LENGTH_LONG )
        Log.i("info", "OnStop Function Executed!")
    }

    override fun onDestroy() { // do last thing
        super.onDestroy()
        Toast.makeText(this, "OnDestroy Function", Toast.LENGTH_LONG )
        Log.i("info", "OnDestroy Function Executed!")
    }
}