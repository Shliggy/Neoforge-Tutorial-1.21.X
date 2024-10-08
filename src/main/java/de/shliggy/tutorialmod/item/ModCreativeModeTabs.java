package de.shliggy.tutorialmod.item;

import de.shliggy.tutorialmod.TutorialMod;
import de.shliggy.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
            .title(Component.translatable("creativetab.tutorialmod.bismuth_items"))
            .displayItems(
                    (itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_BISMUTH);
                        output.accept(ModItems.BISMUTH);

                        output.accept(ModItems.CHISEL);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
            .title(Component.translatable("creativetab.tutorialmod.bismuth_blocks"))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_items_tab"))
            .displayItems(
                    (itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
