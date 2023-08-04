package items;

public abstract class Item {
    private final String name;
    private final int requiredLevel;
    private final Slot slot;

    public Item (String name, int requiredLevel, Slot slot){
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", requiredLevel=" + requiredLevel +
                ", slot='" + slot + '\'' +
                '}';
    }
    public String getName() {
        return name;
    }
    public int getRequiredLevel() {
        return requiredLevel;
    }
    public Slot getSlot() {
        return slot;
    }
}

