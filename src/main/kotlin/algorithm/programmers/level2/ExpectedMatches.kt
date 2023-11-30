package algorithm.programmers.level2

class ExpectedMatches {
    fun solution(n: Int, a: Int, b: Int): Int {
        var round = 1
        var nextA = a
        var nextB = b

        while (!isFight(nextA, nextB)) {
            round++
            nextA = nextNumber(nextA)
            nextB = nextNumber(nextB)
        }
        return round
    }

    private fun nextNumber(nextA: Int): Int = ((nextA - 1) / 2) + 1
    private fun isFight(a: Int, b: Int): Boolean = nextNumber(a) == nextNumber(b)
}