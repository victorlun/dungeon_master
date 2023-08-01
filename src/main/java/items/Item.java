package items;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private String slot;

    public Item (String name, int requiredLevel, String slot){
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }
}

