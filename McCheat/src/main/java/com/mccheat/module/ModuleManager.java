package com.mccheat.module;

import com.mccheat.McCheat;
import com.mccheat.module.modules.combat.*;
import com.mccheat.module.modules.movement.*;
import com.mccheat.module.modules.render.*;
import com.mccheat.module.modules.exploit.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // Combat
        add(new KillAura());
        add(new Criticals());
        add(new AntiKnockback());
        add(new AutoArmor());
        add(new HitboxExpander());
        add(new Reach());
        add(new AutoTotem());
        // Movement
        add(new Flight());
        add(new Speed());
        add(new NoFall());
        add(new Step());
        add(new Sprint());
        add(new Scaffold());
        add(new Parkour());
        add(new Velocity());
        add(new Longjump());
        // Render
        add(new ESP());
        add(new Tracers());
        add(new Fullbright());
        add(new Chams());
        add(new StorageESP());
        add(new HoleESP());
        add(new Nametags());
        // Exploit
        add(new Nuker());
        add(new AutoMine());
        add(new ChestStealer());
        add(new AntiHunger());
        add(new Freecam());
        add(new Phase());
        add(new BookBot());
        add(new ElytraFly());
    }

    private void add(Module m) {
        modules.add(m);
        McCheat.eventBus.subscribe(
            com.mccheat.event.EventTick.class,
            e -> { if (m.isEnabled()) m.onTick(); }
        );
    }

    public List<Module> getModules() { return modules; }

    public Module getByName(String name) {
        return modules.stream()
            .filter(m -> m.getName().equalsIgnoreCase(name))
            .findFirst().orElse(null);
    }
}
