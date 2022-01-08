package com.kotlinflow.examples.ex1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

object Example2 {

    val TAG = "Example2"

    val userList = mutableListOf<String>("User 1", "User 2", "User 3", "User 4", "User 5")

    private fun simpleFlow() : Flow<String> = flow {
        userList.forEach {
            emit(it)
            kotlinx.coroutines.delay(500)
        }
    }

    fun startExample() {
        CoroutineScope(Dispatchers.IO).launch {
            launch {
                simpleFlow().collect {
                    println("simpleFlow 1 Details Collected : $it " )
                }
            }

            launch {
                simpleFlow().collect {
                    println("simpleFlow 2 Details Collected : $it " )
                }
            }

            launch {
                simpleFlow().collect {
                    println("simpleFlow 3 Details Collected : $it " )
                }
            }
        }
    }
}