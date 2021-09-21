import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

class MarkdownParser : CodeParser {
    override fun parseCode(filename: String): List<Node> {
        var node = Node()
        val lines = mutableListOf<Node>()
        val regex = Regex("([*#>]*)(.*?) ?(\\**)")
        val reader = BufferedReader(FileReader(filename))

        var line: String?
        while (reader.readLine().also {
                line = it
            } != null) {
            line?.let {
                var results = regex.matchEntire(it)
                results?.let {

                    for (i in 1 until results.groups.size) {
                        println("Found: ${results.groups[i]?.value}")

                    }
                }
            }
        }
        return lines

    }
}

