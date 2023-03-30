package com.demo.scaler

fun main() {
    val array1 = arrayOf(8, 8, 7, 2, 1, 7, 9)
    val array2 = arrayOf(14, 8, 2, 7, 7)
    // Answer: [8, 14]

    val a = array1.intersect(array2.asIterable().toSet())
    println(a)

    //------------------------
    /**
     * This is my own solution not copied from other sources.
     */

    var missingElements = mutableListOf<Int>()

    //Map for repeating numbers
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
