package com.kotlinflow.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlinflow.examples.ex1.Example1
import com.kotlinflow.examples.ex1.Example2
import com.kotlinflow.examples.ex1.Example3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Example1.startExample()
//        Example2.startExample()
        Example3.startExample()

    }
}