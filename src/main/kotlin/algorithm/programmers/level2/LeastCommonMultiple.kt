package algorithm.programmers.level2

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    LeastCommonMultiple().solution(intArrayOf(1,2,3))
}
class LeastCommonMultiple {
    fun solution(arr: IntArray): Int {
        val primeMap = HashMap<Int, Int>()

        // 소수를 구하고 등록
        (2..100).filter { isPrime(it) }.forEach { primeMap[it] = 0 }

        // 각 수의 소수의 최대값을 map에 등록
        arr.forEach { num ->
            primeMap.keys.forEach { key ->
                val count = divCount(num, key)
                primeMap[key] = count.coerceAtLeast(primeMap[key] ?: count)
            }
        }

        var answer = 1
        for (key in primeMap.keys) {
            val value = primeMap[key]!!.toDouble()
            answer *= key.toDouble().pow(value).toInt()
        }
        return answer
    }

    private fun divCount(num: Int, prime: Int): Int {
        var count = 0
        var nextNum = num
        while (nextNum % prime == 0) {
            nextNum /= prime
            count++
        }
        return count
    }

    private fun isPrime(num: Int): Boolean {
        for (i in 2..sqrt(num.toDouble()).toInt())
            if (num % i == 0) return false
        return true
    }
}