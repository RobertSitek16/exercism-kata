package differenceofsquares

class DifferenceOfSquares {

    def num

    DifferenceOfSquares(def num) {
        this.num = num
    }

    def squareOfSum() {
        def sum = 0
        1.upto(num as Integer) {number ->
            sum += number
        }
        return sum**2
    }

    def sumOfSquares() {
        def sum = 0
        1.upto(num as Integer) { number ->
            sum += number**2
        }
        return sum
    }

    def difference() {
        return squareOfSum() - sumOfSquares()
    }

}
