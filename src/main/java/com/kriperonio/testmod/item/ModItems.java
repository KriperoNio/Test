package com.kriperonio.testmod.item;

import com.kriperonio.testmod.TestMod;
import com.kriperonio.testmod.TestMod_Tabs;
import com.kriperonio.testmod.item.customs.TestCustom;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);








    public static final RegistryObject<Item> BLUEMIRIT = ITEMS.register("bluemirit",
            () -> new Item(new Item.Properties().tab(TestMod_Tabs.TEST_TAB)));

    public static final RegistryObject<Item> RAW_BLUEMIRIT = ITEMS.register("raw_bluemirit",
            () -> new Item(new Item.Properties().tab(TestMod_Tabs.TEST_TAB)));

    public static final RegistryObject<Item> RANDOM_NUMBER = ITEMS.register("random_number",
            () -> new TestCustom(new Item.Properties().tab(TestMod_Tabs.TEST_TAB).stacksTo(1)));








    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
