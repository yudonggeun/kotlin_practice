package algorithm.backjoon.combination
// https://www.acmicpc.net/problem/1256

import java.util.*

val nCr = Array(201) { LongArray(101) }
fun main() {
    val input = StringTokenizer(readln())
    var n = input.nextToken().toInt()
    var m = input.nextToken().toInt()
    var k = input.nextToken().toLong()

    // 사전에 수록되어 있는 문자열의 개수가 k보다 작으면
    if (nCr(n + m, n) < k) {
        println(-1)
        return
    }
    val answer = StringBuilder()
    // 이분 탐색 n개의 a를 선택할 때까지 반복
    while ((n != 0) and (m != 0)) {
        // a를 선택하는 경우의 수
        val caseNumber = nCr(n + m - 1, n - 1)
        //  k 번째 수가 앞쪽 절반에 있는 경우라면
        if (k <= caseNumber) {
            answer.append("a");
            n--
        }
        // 뒤쪽 절반에 있는 경우라면
        else {
            answer.append("z");
            k -= caseNumber
            m--
        }
    }
    repeat(n) { answer.append("a") }
    repeat(m) { answer.append("z") }
    println(answer.toString())
}

/// nCr = n-1Cr-1 + n-1Cr
val MAX: Long = 1_000_000_000
fun nCr(n: Int, r: Int): Long {
    if (nCr[n][r] != 0L) return nCr[n][r]
    nCr[n][r] = if ((r == 0) or (n == r)) 1 else nCr(n - 1, r - 1) + nCr(n - 1, r)
    nCr[n][r] = nCr[n][r].coerceAtMost(MAX)
    return nCr[n][r]
}
