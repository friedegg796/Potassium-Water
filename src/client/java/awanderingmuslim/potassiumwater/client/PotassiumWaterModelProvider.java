package awanderingmuslim.potassiumwater.client;

import awanderingmuslim.potassiumwater.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;

public class PotassiumWaterModelProvider extends FabricModelProvider {
    public PotassiumWaterModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemmodelGenerator) {
        itemmodelGenerator.generateFlatItem(ModItems.POTASSIUM_WATER, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public String getName() {
        return "PotassiumWaterModelProvider";
    }
}
