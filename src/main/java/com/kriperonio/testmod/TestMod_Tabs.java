package com.kriperonio.testmod;

import com.kriperonio.testmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TestMod_Tabs {
    public static final CreativeModeTab TEST_TAB = new CreativeModeTab("test_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BLUEMIRIT.get());
        }
    };
}
