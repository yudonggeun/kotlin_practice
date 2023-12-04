package algorithm.backjoon.combination

fun main() {
    System.`in`.bufferedReader().use {
        val n = it.readLine().toInt()
        println(1 shl n)
    }
}