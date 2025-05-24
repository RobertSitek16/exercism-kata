package wizardsandwarriors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.fail;

class FighterTest {
    private Warrior warrior;
    private Wizard wizard;

    @BeforeEach
    void setup() {
        warrior = new Warrior();
        wizard = new Wizard();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The Warrior class is defined")
    void testWarriorClassExists() {
        try {
            Class.forName("wizardsandwarriors.Warrior");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Warrior");
        }
    }

    @Test
    @Tag("task:1")
    @DisplayName("The Warrior class inherits from the Fighter class")
    void testWarriorIsInstanceOfFighter() throws ClassNotFoundException {
        assertThat(Class.forName("wizardsandwarriors.Warrior")).isAssignableTo(Fighter.class);
    }


    @Test
    @Tag("task:2")
    @DisplayName("The toString method of the Warrior returns the correct description of the fighter")
    void testWarriorToString() {
        assertThat(warrior.toString()).isEqualTo("Fighter is a Warrior");
    }

    @Test
    @Tag("task:3")
    @DisplayName("A Warrior is never vulnerable")
    void testWarriorAlwaysInvulnerable() {
        assertThat(warrior.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("A Warrior deals 10 damage to a vulnerable target")
    void testWarriorsDamagePointsWhenTargetVulnerable() {
        assertThat(warrior.getDamagePoints(new VulnerableFighter())).isEqualTo(10);
    }

    @Test
    @Tag("task:4")
    @DisplayName("A Warrior deals 6 damage to an invulnerable target")
    void testWarriorsDamagePointsWhenTargetNotVulnerable() {
        assertThat(warrior.getDamagePoints(new InvulnerableFighter())).isEqualTo(6);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The Wizard class is defined")
    void testWizardClassExists() {
        try {
            Class.forName("wizardsandwarriors.Wizard");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Wizard");
        }
    }

    @Test
    @Tag("task:5")
    @DisplayName("The Wizard class inherits from the Fighter class")
    void testWizardIsInstanceOfFighter() throws ClassNotFoundException {
        assertThat(Class.forName("wizardsandwarriors.Wizard")).isAssignableTo(Fighter.class);
    }

    @Test
    @Tag("task:6")
    @DisplayName("The toString method of the Wizard returns the correct description of the fighter")
    void testWizardToString() {
        assertThat(wizard.toString()).isEqualTo("Fighter is a Wizard");
    }

    @Test
    @Tag("task:7")
    @DisplayName("The Fighter class does not contain the prepareSpell method")
    void testFighterDoesNotHavePrepareSpellMethod() {
        assertThatExceptionOfType(NoSuchMethodException.class)
                .isThrownBy(() -> Fighter.class.getDeclaredMethod("prepareSpell"));
    }

    @Test
    @Tag("task:7")
    @DisplayName("A Wizard is vulnerable when not prepared with a spell")
    void testWizardVulnerableByDefault() {
        assertThat(wizard.isVulnerable()).isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("A Wizard is not vulnerable when prepared with a spell")
    void testWizardVulnerable() {
        wizard.prepareSpell();
        assertThat(wizard.isVulnerable()).isFalse();
    }


    @Test
    @Tag("task:8")
    @DisplayName("A Wizard deals 3 damage when no spell has been prepared")
    void testWizardsDamagePoints() {
        assertThat(wizard.getDamagePoints(new Fighter())).isEqualTo(3);
    }

    @Test
    @Tag("task:8")
    @DisplayName("A Wizard deals 12 damage after a spell has been prepared")
    void testWizardsDamagePointsAfterPreparingSpell() {
        wizard.prepareSpell();
        assertThat(wizard.getDamagePoints(new Fighter())).isEqualTo(12);
    }

    private static class VulnerableFighter extends Fighter {
        @Override
        boolean isVulnerable() {
            return true;
        }
    }

    private static class InvulnerableFighter extends Fighter {
        @Override
        boolean isVulnerable() {
            return false;
        }
    }
}