import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

class MarkdownParser : CodeParser {
    override fun parseCode(filename: String): List<Node> {
        val lines = mutableListOf<Node>()
        val regex = Regex("([*#>]*)(.*?) ?\\**")
        val reader = BufferedReader(FileReader(filename))

        var line: String?
        while (reader.readLine().also {
                line = it
            } != null) {
            line?.let {
                var results = regex.matchEntire(it)
                var node = Node()
                results?.let {

                    for (i in 1 until results.groups.size) {
                        if (results.groupValues[i] == "**"){
                            node.text = "<b>${results.groupValues[2]}</b>"
                            lines.add(node)
                        }
                        else if (results.groupValues[i] == "*")
                        {
                            node.text = "<i>${results.groupValues[2]}</i>"
                            lines.add(node)
                        }else if (results.groupValues[i] == "#")
                        {
                            node.text = "<h1>${results.groupValues[2]}</h1>"
                            lines.add(node)
                        }
                        else if (results.groupValues[i] == "##")
                        {
                            node.text = "<h2>${results.groupValues[2]}</h2>"
                            lines.add(node)
                        }
                        else if (results.groupValues[i] == "###")
                        {
                            node.text = "<h3>${results.groupValues[2]}</h3>"
                            lines.add(node)
                        }else if (results.groupValues[i] == ">")
                        {
                            node.text = "<blockquote>${results.groupValues[2]}</blockquote>"
                            lines.add(node)
                        }
                    }
                }
            }
        }
        return lines
    }
}

