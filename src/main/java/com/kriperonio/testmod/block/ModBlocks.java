package com.kriperonio.testmod.block;

import com.kriperonio.testmod.TestMod;
import com.kriperonio.testmod.block.customs.TestBlockEffects;
import com.kriperonio.testmod.item.ModItems;
import com.kriperonio.testmod.TestMod_Tabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);









    public static final RegistryObject<Block> BLUEMIRIT_BLOCK = registerBlock("bluemirit_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WATER)
                    .strength(6f).requiresCorrectToolForDrops()), TestMod_Tabs.TEST_TAB);

    public static final RegistryObject<Block> JUMP_BLOCK = registerBlock("jump_block",
            () -> new TestBlockEffects(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), TestMod_Tabs.TEST_TAB);









    private static  <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
