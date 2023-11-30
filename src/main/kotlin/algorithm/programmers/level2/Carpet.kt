package algorithm.programmers.level2

class Carpet {
    fun solution(brown: Int, yellow: Int): IntArray {
        val sum = brown + yellow
        val b: Int = (1..brown) .find { b -> getA(b, brown) * b == sum } ?: return intArrayOf()
        return intArrayOf(getA(b, brown), b).sortedArrayDescending()
    }

    private fun getA(b: Int, brown: Int): Int = 2 - b + (brown / 2)
}