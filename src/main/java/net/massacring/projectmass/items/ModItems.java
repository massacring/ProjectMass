package net.massacring.projectmass.items;

import net.massacring.projectmass.ProjectMass;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectMass.MOD_ID);

    public static final RegistryObject<Item> GALVANIZED_SQUARE_STEEL = ITEMS.register("galvanized_square_steel",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
