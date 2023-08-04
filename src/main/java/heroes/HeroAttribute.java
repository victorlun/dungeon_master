package heroes;

import java.util.Objects;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
    public HeroAttribute add(HeroAttribute heroAttribute) {
        return new HeroAttribute(
                this.strength + heroAttribute.strength,
                this.dexterity + heroAttribute.dexterity,
                this.intelligence + heroAttribute.intelligence
        );
    }
    public HeroAttribute addFromArmor(HeroAttribute heroAttribute) {
        return new HeroAttribute(
                this.strength += heroAttribute.getStrength(),
                this.dexterity += heroAttribute.getDexterity(),
                this.intelligence += heroAttribute.getIntelligence()
        );
    }
    public int getStrength() {
        return strength;
    }
    public int getDexterity() {
        return dexterity;
    }
    public int getIntelligence() {
        return intelligence;
    }
    @Override
    public String toString() {
        return "Str:" + this.strength + " Dex:" + this.dexterity + " Int:" + this.intelligence;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroAttribute that = (HeroAttribute) o;
        return strength == that.strength && dexterity == that.dexterity && intelligence == that.intelligence;
    }
    @Override
    public int hashCode() {
        return Objects.hash(strength, dexterity, intelligence);
    }
}