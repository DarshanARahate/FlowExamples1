package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

object Example15 {

    val userIds = listOf(10,20,30,40,50,60,70,80,90)
    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")


    fun startExample(lifecycleScope: LifecycleCoroutineScope) {
        lifecycleScope.launch {
            userList.asFlow().zip(userIds.asFlow()) { user, age ->
                "User : $user -- Age : $age"
            } .collect {
                println("Collected Output : $it")
            }
        }
    }

}