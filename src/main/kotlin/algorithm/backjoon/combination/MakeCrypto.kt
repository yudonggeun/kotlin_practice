package algorithm.backjoon.combination

import java.util.*

val vowel = hashSetOf('a', 'e', 'i', 'o', 'u')
fun main() {
    val len = StringTokenizer(readln()).nextToken().toInt()
    val input = readln()
        .replace(" ", "")
        .toCharArray()
        .sorted()

    generate(input, len, 0, charArrayOf(), 0)
}

fun generate(
    input: List<Char>,
    len: Int,
    vowelCount: Int,
    result: CharArray,
    start: Int
) {
    if (result.size == len) {
        if (vowelCount > 0 && len - vowelCount > 1)
            println(result.joinToString(""))
        return
    }

    for (i in start..input.lastIndex) {
        generate(
            input,
            len,
            if (input[i] in vowel) vowelCount + 1 else vowelCount,
            result + input[i],
            i + 1
        )
    }
}
