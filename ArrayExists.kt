package com.demo.scaler

fun main() {
    /**
     * This is my own solution not copied from other sources.
     * Please paste All code into a kotlin playground and run as is.
     * I have checked from my end it works as given in example problems.
     * Works both for int and string array
     */
    val array1 = arrayOf(9, 4, 7, 9, 3)
    val array2 = arrayOf(9, 11, 9, 13, 9)
    // Answer: [9, 11, 13]

//    UnComment this Code for String Array Check
//    val array1 = arrayOf("goat", "fish", "deer", "goat", "bear")
//    val array2 = arrayOf("ant", "bear", "goat")
    //Answer: ["ant", "goat"]

    val stringArray1 = array1.map { it.toString() }.toTypedArray()
    val stringArray2 = array2.map { it.toString() }.toTypedArray()
    solve(stringArray1, stringArray2, array1.firstOrNull()?.getType())
}

fun solve(array1: Array<String>, array2: Array<String>, isType: VariableType?) {
    var missingElements = mutableListOf<String>()

    //Map for repeating numbers
    val elementCountMap: MutableMap<String, Int> = array1.groupingBy { it }.eachCount().toMutableMap()

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

    if (isType == VariableType.INT) {
        var missing = missingElements.map { it.toInt() }.toMutableList()
        missing.sort()
        println(missing)   // prints: [9, 11, 13], ["ant", "goat"]
    } else {
        missingElements.sort()
        println(missingElements)   // prints: [9, 11, 13], ["ant", "goat"] 
    }
}

fun Any.getType(): VariableType {
    return when (this) {
        is Int -> VariableType.INT
        is String -> VariableType.STRING
        else -> VariableType.UNKNOWN
    }
}

enum class VariableType {
    INT, STRING, PLAYER, UNKNOWN
}
