package com.kotlinflow.examples.ex1


import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object Example11 {

    val ageList = listOf(10, 20, 30, 40, 50, 60, 70, 80, 90)
    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        lifecycleScope.launch {
            ageFlow().onCompletion {
                println("${Thread.currentThread().name} : Declaration : Flow has completed")
            }.collect {
                println("${Thread.currentThread().name} :: $it")
            }
        }
    }

    private fun ageFlow(): Flow<Int> = ageList.asFlow()
        .transform {
            println("In Transform ${Thread.currentThread().name}")
            if (it == 30) {
                emit(it + 1)
            } else {
                emit(it)
            }
        }.flowOn(Dispatchers.IO)


}