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
                var node = MarkdownNode()
                results?.let {

                    for (i in 1 until results.groups.size-1) {
                        //println(results.groupValues[0])
                        if (results.groupValues[i] == "**"){
                            node.text = results.groupValues[2]
                            node.type = 5
                            lines.add(node)
                        }
                        else if (results.groupValues[i] == "*")
                        {
                            node.text = results.groupValues[2]
                            node.type = 6
                            lines.add(node)
                        }else if (results.groupValues[i] == "#")
                        {
                            node.text = results.groupValues[2]
                            node.type = 1
                            lines.add(node)
                        }
                        else if (results.groupValues[i] == "##")
                        {
                            node.text = results.groupValues[2]
                            node.type = 2
                            lines.add(node)
                        }
                        else if (results.groupValues[i] == "###")
                        {
                            node.text = results.groupValues[2]
                            node.type = 3
                            lines.add(node)
                        }else if (results.groupValues[i] == ">")
                        {
                            node.text = results.groupValues[2]
                            node.type = 7
                            lines.add(node)
                        }else if(results.groupValues[i]=="")
                        {
                            node.text = results.groupValues[2]
                            node.type = 4
                            lines.add(node)
                        }
                    }
                }
            }
        }
        return lines
    }
}

