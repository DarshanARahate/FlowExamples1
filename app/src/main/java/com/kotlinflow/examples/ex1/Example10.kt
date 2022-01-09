package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object Example10 {

    val userIds = listOf(10,20,30,40,50,60,70,80,90)
    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        // Imperative Completion
        lifecycleScope.launch(Dispatchers.IO) {
           try {
               userIds.asFlow()
                   .collect {
                       println("Imperative Completion Values : $it")
                   }
           } finally {
               println("Flow Process Completed() ")
           }
        }
        // Declarative Completion
        lifecycleScope.launch(Dispatchers.IO) {
            var sum =  userIds.asFlow()
                .onCompletion {
                    println("OnComplete ----- ")
                }
                .collect {
                    println("Declarative Completion Values : $it")
                }
            println("SUM : $sum")

        }

    }
}