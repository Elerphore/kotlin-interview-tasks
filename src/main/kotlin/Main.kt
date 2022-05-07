import java.util.Arrays

fun main(args: Array<String>) {
    val rows = 3;
    val columns = 3;
    val matrix = Array(rows) { Array(columns) { 0 } }

    matrix[0] = arrayOf(1, 4, 7)
    matrix[1] = arrayOf(2, 5, 8)
    matrix[2] = arrayOf(3, 6, 9)

    render(matrix)

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

    println("============")
    render(matrix)
}

fun render(matrix: Array<Array<Int>>) = (matrix.map { println(it.joinToString(" ")) });