package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

object Example8 {

    val userIds = listOf(10,20,30,40,50,60,70,80,90)

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        lifecycleScope.launch(Dispatchers.IO) {
            userIds.asFlow()
                .take(3)
                .collect {
                    println("User Id : $it")
                }
        }

    }



}