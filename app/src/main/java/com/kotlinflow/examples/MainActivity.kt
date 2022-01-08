package com.kotlinflow.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.kotlinflow.examples.ex1.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Example1.startExample()
//        Example2.startExample()
//        Example3.startExample()
//        Example4.startExample(lifecycleScope)
//        Example5.startExample(lifecycleScope)
        Example6.startExample(lifecycleScope)


    }
}