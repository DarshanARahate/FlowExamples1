package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object Example18 {

    val userIds = listOf(10,20,30,40,50,60,70,80,90)
    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        lifecycleScope.launch {
            val startTime = System.currentTimeMillis()
            userIds.asFlow()
                .onEach { delay(100) }
                .flatMapMerge { age ->
                    userList.asFlow()
                        .map { user ->
                            delay(400)
                            "Age : $age - User: $user"
                        }
                }.collect {
                    println("flatMapMerge : $it")
                }
        }
    }
}