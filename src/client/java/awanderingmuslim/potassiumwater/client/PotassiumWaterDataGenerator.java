package awanderingmuslim.potassiumwater.client;

import awanderingmuslim.potassiumwater.PotassiumWater;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PotassiumWaterDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack potassiumpack = fabricDataGenerator.createPack();
        potassiumpack.addProvider(PotassiumWaterModelProvider::new);
        PotassiumWater.LOGGER.info("Potassium Water's Datageneration has been initialized!");
    }
}
