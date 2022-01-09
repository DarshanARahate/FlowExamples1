package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

object Example14 {

    private fun numFlow() : Flow<Int> = flow {
        for  (i in 1..10) {
            delay(100)
            println("Log1 : ${Thread.currentThread().name}")
            emit(i)
        }
    }

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        lifecycleScope.launch {
            val time = measureTimeMillis {

                numFlow()
                    .collectLatest {
                        println("Collecting the value $it")
                        delay(200)
                        println("Log2 ${Thread.currentThread().name}  :: $it")
                    }
            }
            println("Total time $time")
        }
    }

}