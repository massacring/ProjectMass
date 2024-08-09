package net.massacring.projectmass.datagen;

import io.netty.channel.socket.nio.NioDatagramChannel;
import net.massacring.projectmass.ProjectMass;
import net.massacring.projectmass.blocks.ModBlocks;
import net.massacring.projectmass.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ProjectMass.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_TIN);
        simpleItem(ModItems.TIN_INGOT);
        simpleItem(ModItems.STEEL_INGOT);

        simpleBlockItem(ModBlocks.GALVANIZED_SQUARE_STEEL_DOOR);

        evenSimplerBlockItem(ModBlocks.GALVANIZED_SQUARE_STEEL_STAIRS);
        evenSimplerBlockItem(ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB);
        evenSimplerBlockItem(ModBlocks.GALVANIZED_SQUARE_STEEL_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.GALVANIZED_SQUARE_STEEL_FENCE_GATE);

        trapdoorItem(ModBlocks.GALVANIZED_SQUARE_STEEL_TRAPDOOR);
        fenceItem(ModBlocks.GALVANIZED_SQUARE_STEEL_FENCE, ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK);
        buttonItem(ModBlocks.GALVANIZED_SQUARE_STEEL_BUTTON, ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK);
        wallItem(ModBlocks.GALVANIZED_SQUARE_STEEL_WALL, ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProjectMass.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProjectMass.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ProjectMass.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ProjectMass.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ProjectMass.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(ProjectMass.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
