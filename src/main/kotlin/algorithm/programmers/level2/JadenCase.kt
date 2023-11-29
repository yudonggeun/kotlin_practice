package algorithm.programmers.level2

class JadenCase {
    fun solution(s: String): String {
        val array = s.lowercase().toCharArray()
        for (i in 1..array.lastIndex) {
            if (array[i - 1] == ' ' && array[i] in 'a'..'z') {
                array[i] = array[i].uppercaseChar()
            }
        }
        if (array[0].isLowerCase()) array[0] = array[0].uppercaseChar()
        return array.concatToString()
    }
}