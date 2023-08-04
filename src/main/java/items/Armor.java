package items;
import heroes.HeroAttribute;

public class Armor extends Item {
    private final ArmorType armorType;
    private final HeroAttribute armorAttribute;
    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }
    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }
    public ArmorType getArmorType() {
        return armorType;
    }
    @Override
    public String toString() {
        return "\n  [Name]:" + getName() + " [Req.Lvl]:" + getRequiredLevel() + " [Slot]:" + getSlot() + " [Type]:" + armorType + " [Attribute]:" + armorAttribute;
    }
}
