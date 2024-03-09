package highscores

import spock.lang.Specification

class HighScoresTest extends Specification {

    def "List of scores"() {
        expect:
        new HighScores(scores).scores == expected

        where:
        scores           || expected
        [30, 50, 20, 70] || [30, 50, 20, 70]
    }

    def "Latest score"() {
        expect:
        new HighScores(scores).latest() == expected

        where:
        scores           || expected
        [100, 0, 90, 30] || 30
    }

    def "Personal best"() {
        expect:
        new HighScores(scores).personalBest() == expected

        where:
        scores        || expected
        [40, 100, 70] || 100
    }

    def "Top 3 scores"() {
        expect:
        new HighScores(scores).personalTopThree() == expected

        where:
        scores                                               || expected
        [10, 30, 90, 30, 100, 20, 10, 0, 30, 40, 40, 70, 70] || [100, 90, 70]
    }

    def "Personal top highest to lowest"() {
        expect:
        new HighScores(scores).personalTopThree() == expected

        where:
        scores       || expected
        [20, 10, 30] || [30, 20, 10]
    }

    def "Personal top when there is a tie"() {
        expect:
        new HighScores(scores).personalTopThree() == expected

        where:
        scores           || expected
        [40, 20, 40, 30] || [40, 40, 30]
    }

    def "Personal top when there are less than 3"() {
        expect:
        new HighScores(scores).personalTopThree() == expected

        where:
        scores   || expected
        [30, 70] || [70, 30]
    }

    def "Personal top when there is only one"() {
        expect:
        new HighScores(scores).personalTopThree() == expected

        where:
        scores || expected
        [40]   || [40]
    }

    def "Personal top three does not mutate"() {
        given:
        def hs = new HighScores(scores)
        def top3 = hs.personalTopThree()

        expect:
        hs.latest() == expected

        where:
        scores           || expected
        [40, 20, 10, 30] || 30
    }

}
