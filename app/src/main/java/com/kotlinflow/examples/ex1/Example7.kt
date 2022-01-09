package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object Example7 {

    val userIds = listOf(10,20,30,40,50,60,70,80,90)

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        lifecycleScope.launch(Dispatchers.IO) {
             userIds.asFlow()
                .transform {
                    emit("transform Age1 : $it")
                    emit("transform Age2 : $it")
                }
                .collect {
                    println("User List : $it")
                }
        }

    }




}