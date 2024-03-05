package armstrongnumbers

class ArmstrongNumber {

    static boolean isArmstrongNumber(def number) {
        String numberString = number as String
        List<Integer> digitsOfNumber = []
        numberString.each { digitsOfNumber << it.toInteger() }
        def power = digitsOfNumber.size()
        def digitsSum = 0
        digitsOfNumber.each {
            if (it != 0) {
                digitsSum += it ** power
            }
        }
        return number == digitsSum
    }

}
