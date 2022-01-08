package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object Example6 {


    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        lifecycleScope.launch(Dispatchers.IO) {
            simpleFlow()
                .filter {
                    it == "User 3"
                }
                .map {
                    "Name : $it"
                }
                .collect {
                    println("User List : $it")
                }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            userIds.asFlow().filter {
                it % 3 == 1
            }
                .map {
                    "Age : $it"
                }
                .collect {
                    println("User ids : $it")
                }
        }
    }

    private fun simpleFlow(): Flow<String> = flow {
        userList.forEach {
            emit(it)
            delay(5000)
        }
    }

    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")
    val userIds = listOf(10, 20, 30, 40, 50, 60, 70, 80, 90)


}