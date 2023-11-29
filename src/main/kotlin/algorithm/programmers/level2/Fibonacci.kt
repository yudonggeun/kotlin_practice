package algorithm.programmers.level2
class Fibonacci {
    fun solution(n: Int): Int {
        val dp = IntArray((n + 1).coerceAtLeast(2))
        dp[1] = 1

        for (i in 2..dp.lastIndex) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        }
        return dp[n]
    }
}