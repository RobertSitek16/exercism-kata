package wizardsandwarriors;

public class Wizard extends Fighter {
    private boolean hasPreparedSpell = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    void prepareSpell() {
        hasPreparedSpell = true;
    }

    @Override
    boolean isVulnerable() {
        return !hasPreparedSpell;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return hasPreparedSpell ? 12 : 3;
    }
}
