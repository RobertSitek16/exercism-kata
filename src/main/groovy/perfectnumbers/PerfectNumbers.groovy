package perfectnumbers

class PerfectNumbers {

    static Classification classify(int num) {
        if (num <= 0) {
            throw new ArithmeticException()
        } else if (num == 1) {
            return Classification.DEFICIENT
        }
        List<Integer> numDivisors = getDivisors(num)
        int sumAllDivisors = numDivisors.sum() as int
        switch (num) {
            case { num < sumAllDivisors } -> Classification.ABUNDANT
            case { num == sumAllDivisors } -> Classification.PERFECT
            case { num > sumAllDivisors } -> Classification.DEFICIENT
            default -> throw new ArithmeticException()
        }
    }

    static List<Integer> getDivisors(int num) {
        List<Integer> divisors = []
        int sqrtNum = Math.sqrt(num).toInteger()
        (1..sqrtNum).each { i ->
            if (num % i == 0) {
                divisors.add(i)
                if (i != 1 && num / i != i) {
                    divisors.add(num / i as Integer)
                }
            }
        }
        return divisors
    }

}
