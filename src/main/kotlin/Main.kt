import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import kotlin.reflect.typeOf

fun main(args: Array<String>) {
//    val lines = mutableListOf<String>()
//
//    val reader = BufferedReader(FileReader("input.c"))
//    val writer = BufferedWriter(FileWriter("output.c"))
//
//    var line:String?
//    while(reader.readLine().also {
//            line = it
//        } != null) {
//        line?.let {
//            lines.add(it)
//        }
//    }
//
//    for (line in lines) {
//        writer.write(line + "\n")
//    }
//    writer.flush()


    /*
    *		O or more
    +		1 or more
    ?		0 or 1 (non-greedy, important)
     */
//    val sentence = "this    is some code"
//    val regex = Regex("(.*?)\\s+is some\\s(.*)")
//    val sentence = "This is some code worth $100.01"
//    val regex = Regex(".*?(\\d+\\.\\d\\d)")

//    val cAssign1 = "int x = 5;"
//    val cAssign2 = "float f = 3.14;"
//
//    val regex = Regex("(int|float) ([a-z]+) = (.*?);")
//
//    if (regex.matches(cAssign2)) {
//        println("It matches!")
//    }
//    val results = regex.matchEntire(cAssign2)
//    results?.let {
//        for(i in 1 until results.groups.size) {
//            println("Found: ${results.groups[i]?.value}")
//        }
//    }
    var markdown = MarkdownParser()
    var x = markdown.parseCode("Markdown.md")

}

