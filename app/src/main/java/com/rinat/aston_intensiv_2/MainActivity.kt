package com.rinat.aston_intensiv_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.view.View
import android.widget.Button
import androidx.annotation.IdRes

class MainActivity : AppCompatActivity() {

    private val buttonFirstTask by bind<Button>(R.id.buttonFirst)
    private val buttonSecondTask by bind<Button>(R.id.buttonSecond)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFirstTask.setOnClickListener {
            val intent = Intent(this, FirstTask::class.java)
            startActivity(intent)
        }

        buttonSecondTask.setOnClickListener {
            val intent = Intent(this, SecondTask::class.java)
            startActivity(intent)
        }

    }

    fun <T: Any?> bind(@IdRes idRes: Int): Lazy<T>{
        return  lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

}