package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

object Example4 {
    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

//        CoroutineScope(Dispatchers.IO).launch() {
//            simpleFlow().collect {
//                println("User List : $it")
//            }
//        }
        lifecycleScope.launch(Dispatchers.IO) {
            simpleFlow().collect {
                println("User List : $it")
            }
        }
    }

    private fun simpleFlow() : Flow<String> = flow {
        userList.forEach {
            emit(it)
            delay(5000)
        }
    }

    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")




}