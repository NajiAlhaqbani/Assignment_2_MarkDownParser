class MarkdownNode : Node() {
    var type:Int = 0
    override fun toHTML(): String {
        TODO("Just check the type and return the html tag and the text string")
        if(type==1)
        {
            //return "<h1>${this.text} </h1>"
        }
    }
}