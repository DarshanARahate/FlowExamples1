package com.kotlinflow.examples.ex1

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


object Example1 {

    val TAG = "Example1"
    val usersList = mutableListOf<String>("User 1", "User 2", "User 3", "User 4", "User 5")

    private fun simpleFlow(): Flow<String> = flow {
        usersList.forEach {
            emit(it)
            delay(500)
        }
    }

    fun startExample() {
        CoroutineScope(Dispatchers.IO).launch {

            simpleFlow().collect {
                println("User 1 Details Collected : $it ")
            }
        }
    }
}



