package leap

class Leap {

    def year

    Leap(Integer year) {
        this.year = year
    }

    def isLeapYear() {
        switch (year) {
            case { year % 4 == 0 && year % 100 != 0 } -> true
            case { year % 400 == 0 } -> true
            default -> false
        }
    }

}
