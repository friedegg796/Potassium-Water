package awanderingmuslim.potassiumwater;

import awanderingmuslim.potassiumwater.item.ModItemGroups;
import awanderingmuslim.potassiumwater.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PotassiumWater implements ModInitializer {
    public static final String MOD_ID = "potassium-water";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModItemGroups.initalize();

        // Loot drops for our water begin here
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {

            if (BuiltInLootTables.IGLOO_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.POTASSIUM_WATER)
                                .setWeight(100)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))
                                ));


                tableBuilder.pool(poolBuilder.build());
            }

            if (BuiltInLootTables.JUNGLE_TEMPLE.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.POTASSIUM_WATER)
                                .setWeight(75)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))
                                ));


                tableBuilder.pool(poolBuilder.build());
            }

            if (BuiltInLootTables.ANCIENT_CITY.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.POTASSIUM_WATER)
                                .setWeight(60)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 15.0F))
                                ));

                tableBuilder.pool(poolBuilder.build());
            }


            if (BuiltInLootTables.END_CITY_TREASURE.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.POTASSIUM_WATER)
                                .setWeight(100)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))
                                ));

                tableBuilder.pool(poolBuilder.build());
            }

        });
        //Lootdrops for our water end here

        LOGGER.info("This is" + MOD_ID);

    }
}