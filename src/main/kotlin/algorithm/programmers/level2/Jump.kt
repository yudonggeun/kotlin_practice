package algorithm.programmers.level2

class Jump {
    fun solution(n: Int): Long {
        val MAX = 1234567L
        val dp = LongArray(n + 2) { 1 }
        (2..n).forEach { dp[it] = (dp[it - 1] + dp[it - 2]) % MAX }
        return dp[n]
    }
}