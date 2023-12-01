package algorithm.programmers.level2

class Jump {
    fun solution(n: Int): Long {
        val MOD = 1234567L
        val dp = LongArray(n + 2) { 1 }
        for (i in 2..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD
        }
        return dp[n]
    }
}