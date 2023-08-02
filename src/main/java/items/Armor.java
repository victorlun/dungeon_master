package items;

import heroes.HeroAttribute;

public class Armor extends Item {
    private ArmorType armorType;
    private HeroAttribute armorAttribute;
    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    @Override
    public String toString() {
        return "[Name]:" + getName() + " [Req.Lvl]:" + getRequiredLevel() + " [Slot]:" + getSlot() + " [Type]:" + armorType + " [Attribute]:" + armorAttribute;
    }
}
