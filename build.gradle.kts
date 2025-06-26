if (layout.projectDirectory.file("config.txt").asFile.readText().isNotEmpty()) {
    println("loaded config.txt")
}

tasks.register("demoTask") {
    val input = layout.projectDirectory.file("input.txt")
    inputs.files(input)
    doLast {
        println(input.asFile.readText())
    }
}
