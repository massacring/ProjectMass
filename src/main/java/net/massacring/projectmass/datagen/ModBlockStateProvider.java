package net.massacring.projectmass.datagen;


import net.massacring.projectmass.ProjectMass;
import net.massacring.projectmass.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ProjectMass.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK);

        blockWithItem(ModBlocks.RAW_TIN_BLOCK);

        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);

        stairsBlock(((StairBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_STAIRS.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_BUTTON.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_FENCE.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_FENCE_GATE.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_WALL.get()), blockTexture(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_DOOR.get()), modLoc("block/galvanized_square_steel_door_bottom"), modLoc("block/galvanized_square_steel_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.GALVANIZED_SQUARE_STEEL_TRAPDOOR.get()), modLoc("block/galvanized_square_steel_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
