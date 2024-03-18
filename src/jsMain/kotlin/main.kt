fun main() {
    Test(1.0)
}

class Test(param1: (Double) -> Double, param2: Double) {
    // or any other `<reserved-keyword>: Double`
    constructor(void: Double) : this(if (void == 0.0) { x -> x } else { x -> x + void * 2 }, void)
}