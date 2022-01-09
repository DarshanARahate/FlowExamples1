package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

object Example12 {

    private fun numFlow() : Flow<Int> = flow {
        for  (i in 1..10) {
            delay(200)
            println("Log1 : ${Thread.currentThread().name}")
            emit(i)
        }
    }

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        val time = measureTimeMillis {
            lifecycleScope.launch {
                numFlow()
                    .buffer()
                    .collect {
                        delay(100)
                        println("Log2 ${Thread.currentThread().name}  :: $it")
                    }
            }
        }
        println("Total time $time")
    }

}