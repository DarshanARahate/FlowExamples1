package com.kotlinflow.examples.ex1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

object Example3 {

    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")

    val flowUserList = flowOf("User 11", "User 12", "User 13", "User 14", "User 15")

    fun startExample() {
        CoroutineScope(Dispatchers.IO).launch {
            launch {
                flowUserList.collect {
                    println("In FlowUserList : $it")
                }
            }
            launch {
                userList.asFlow().collect {
                    println("In UserList asFlow Method : $it")
                }
            }
        }
    }


}