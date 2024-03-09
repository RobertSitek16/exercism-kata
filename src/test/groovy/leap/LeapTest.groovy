package leap

import spock.lang.Specification

class LeapTest extends Specification {

    def "Year not divisible by 4 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        2015 || false
    }

    def "Year divisible by 2, not divisible by 4 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        1970 || false
    }

    def "Year divisible by 4, not divisible by 100 in leap year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        1996 || true
    }

    def "Year divisible by 100, not divisible by 400 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        2100 || false
    }

    def "Year divisible by 100 but not by 3 is still not a leap year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        1900 || false
    }

    def "Year divisible by 400 in leap year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        2000 || true
    }

    def "Year divisible by 400 but not by 125 is still a leap year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        2400 || true
    }

    def "Year divisible by 200, not divisible by 400 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        1800 || false
    }

}
