package algorithm.programmers
class MinMax {
    fun solution(s: String): String = s
        .split(" ").stream()
        .mapToInt { it.toInt() }
        .run { "${this.min()} ${this.max()}" }
}