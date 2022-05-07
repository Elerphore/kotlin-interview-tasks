import java.util.Arrays

fun main(args: Array<String>) {
    val rows = 3;
    val columns = 3;
    val matrix = Array(rows) { Array(columns) { 0 } }

    matrix[0] = arrayOf(1, 4, 7)
    matrix[1] = arrayOf(2, 5, 8)
    matrix[2] = arrayOf(3, 6, 9)

    val command = readln()

    when(command.toString()) {
        "ClockWise" -> rotateBy90ClockWise(matrix)
        "counterClockWise" -> rotateBy90CounterClockWise(matrix)
    }

    print("Command: $command \n" + render(matrix).joinToString(separator = "\n"))
}

fun render(matrix: Array<Array<Int>>) = (matrix.map { (it.joinToString(separator = " ", prefix = "", postfix = "")) })

fun rotateBy90ClockWise(matrix: Array<Array<Int>>) =
    matrix.size.let { rows ->
        for(i in matrix.indices) {
            var temp: Int;
            var j = i;
            while(j < rows) {
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
                j++;
            }
        }

        for(i in matrix.indices) {
            val temp: Int = matrix[i][matrix[i].size - 1]
            matrix[i][matrix[i].size - 1] = matrix[i][0]
            matrix[i][0] = temp
        }
    }

fun rotateBy90CounterClockWise(matrix: Array<Array<Int>>) =
    matrix.size.let { rows ->
        val rows = matrix.size / 2
        for(i in 0 until rows) {
            val top = i
            val bottom = matrix.size - 1 - i

            for(j in 0 until bottom) {
                val temp = matrix[top][j]
                matrix[top][j] = matrix[j][bottom]
                matrix[j][bottom] = matrix[bottom][bottom - (j - top)]
                matrix[bottom][bottom - (j - top)] = matrix[bottom - (j - top)][top]
                matrix[bottom - (j - top)][top] = temp
            }
        }
    }
