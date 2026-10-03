package com.mccheat;

import com.mccheat.module.ModuleManager;
import com.mccheat.event.EventBus;
import com.mccheat.util.Logger;
import net.fabricmc.api.ModInitializer;

public class McCheat implements ModInitializer {
    public static final String NAME    = "McCheat";
    public static final String VERSION = "1.0.0";
    public static McCheat      INSTANCE;
    public static ModuleManager modules;
    public static EventBus      eventBus;

    @Override
    public void onInitialize() {
        INSTANCE = this;
        eventBus = new EventBus();
        modules  = new ModuleManager();
        Logger.info(NAME + " v" + VERSION + " loaded — full rise");
    }
}
