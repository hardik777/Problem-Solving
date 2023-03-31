package com.demo.scaler

fun main() {  
    /**
     * This is my own solution not copied from other sources.
     * Please paste this 2 functions code together into a kotlin playground and run as is.
     * I have checked from my end it works as given in example problems.
     */
    val array1 = arrayOf(9, 4, 7, 9, 3)
    val array2 = arrayOf(9, 11, 9, 13, 9)
    // Answer: [9, 11, 13]

    //  val array1 = arrayOf("goat", "fish", "deer", "goat", "bear")
    // 	val array2 = arrayOf("ant", "bear", "goat")
    //Answer: ["ant", "goat"]   //For String array: Change solve function params as per given comments

    solve(array1, array2)
}

fun solve(array1: Array<Int>, array2: Array<Int>) {  //For String array: solve(array1: Array<String>, array2: Array<String>)
    var missingElements = mutableListOf<Int>()  //For String array: var missingElements = mutableListOf<String>()

    //Map for repeating numbers
    //For String array: val elementCountMap: MutableMap<String, Int> = array1.groupingBy { it }.eachCount().toMutableMap()
    val elementCountMap: MutableMap<Int, Int> = array1.groupingBy { it }.eachCount().toMutableMap()

    array2.forEach { it ->
        if (elementCountMap.containsKey(it)) {
            elementCountMap[it] = elementCountMap.getValue(it) - 1  //Decrease freq. of element count and remove if it becomes 0
            if (elementCountMap[it] == 0) elementCountMap.remove(it)
        } else {
            missingElements.add(it)
        }
    }

    for (element in array2) {
        if (elementCountMap.containsKey(element) && elementCountMap[element] != 0) {
            missingElements.add(element)  //Get unique elements
        }
    }

    missingElements.sort()
    println(missingElements)
}
