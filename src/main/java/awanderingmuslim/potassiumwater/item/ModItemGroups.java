package awanderingmuslim.potassiumwater.item;

import awanderingmuslim.potassiumwater.PotassiumWater;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final ResourceKey<CreativeModeTab> POTASSIUM_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(PotassiumWater.MOD_ID, "potassiumwater")
    );
    public static final CreativeModeTab POTASSIUM_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.POTASSIUM_WATER))
            .title(Component.translatable("creativeTab.potassium-water"))
            .displayItems((params, output) -> {
                output.accept(ModItems.POTASSIUM_WATER);
            })
            .build();


    public static void initalize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, POTASSIUM_TAB_KEY, POTASSIUM_CREATIVE_TAB);
        PotassiumWater.LOGGER.info("Potassium Water's Item groups have been initialized!");
    }


}
