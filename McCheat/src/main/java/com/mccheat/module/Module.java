package com.mccheat.module;

public abstract class Module {
    public enum Category { COMBAT, MOVEMENT, RENDER, EXPLOIT, MISC }

    protected final String   name;
    protected final Category category;
    protected       boolean  enabled;
    protected       int      key;

    public Module(String name, Category category, int key) {
        this.name     = name;
        this.category = category;
        this.key      = key;
        this.enabled  = false;
    }

    public void onEnable()  {}
    public void onDisable() {}
    public void onTick()    {}

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable(); else onDisable();
    }

    public boolean isEnabled() { return enabled; }
    public String  getName()   { return name; }
    public Category getCategory() { return category; }
}
