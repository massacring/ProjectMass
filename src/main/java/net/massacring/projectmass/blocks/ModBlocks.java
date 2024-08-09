package net.massacring.projectmass.blocks;

import net.massacring.projectmass.ProjectMass;
import net.massacring.projectmass.items.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectMass.MOD_ID);

    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_BLOCK = registerBlock("galvanized_square_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));

    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_STAIRS = registerBlock("galvanized_square_steel_stairs",
            () -> new StairBlock(() -> ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_SLAB = registerBlock("galvanized_square_steel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_BUTTON = registerBlock("galvanized_square_steel_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_PRESSURE_PLATE = registerBlock("galvanized_square_steel_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_FENCE = registerBlock("galvanized_square_steel_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_FENCE_GATE = registerBlock("galvanized_square_steel_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                    SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_WALL = registerBlock("galvanized_square_steel_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_DOOR = registerBlock("galvanized_square_steel_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),
                    BlockSetType.STONE));
    public static final RegistryObject<Block> GALVANIZED_SQUARE_STEEL_TRAPDOOR = registerBlock("galvanized_square_steel_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),
                    BlockSetType.STONE));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }
}
