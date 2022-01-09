package com.kotlinflow.examples.ex1

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object Example9 {

    val userIds = listOf(10,20,30,40,50,60,70,80,90)
    val userList = listOf("User 1", "User 2", "User 3", "User 4", "User 5")

    fun startExample(lifecycleScope: LifecycleCoroutineScope) {

        lifecycleScope.launch(Dispatchers.IO) {
          var sum =  userIds.asFlow()
                .map {
                    it
                }
                .reduce { a, b ->
                    a + b
                }
            println("SUM : $sum")

            val value = userList.asFlow()
                .map {
                    "$it "
                }
                .reduce { a, b ->
                    a + b
                }
            println("Reduce Example : $value")

            val valueToList = userList.asFlow()
                .toList()
            println("Reduce Example valueToList: $valueToList")

            val valueToSet = userList.asFlow()
                .toSet()
            println("Reduce Example valueToSet: $valueToSet")

            val valueToFirst = userList.asFlow()
                .first()
            println("Reduce Example valueToFirst: $valueToFirst")


        }

    }


}