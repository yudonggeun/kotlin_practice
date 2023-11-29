package algorithm.programmers.level2

class ConvertBinary {
    fun solution(s: String): IntArray {
        var tem = s
        var repeatCount = 0
        var removeZeroCount = 0
        while (tem.length != 1) {
            val zeroCount = tem.count { it == '0' }
            val len = tem.length - zeroCount
            tem = len.toString(2)
            repeatCount++
            removeZeroCount += zeroCount
        }

        return intArrayOf(repeatCount, removeZeroCount)
    }
}