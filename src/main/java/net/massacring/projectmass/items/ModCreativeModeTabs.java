package net.massacring.projectmass.items;

import net.massacring.projectmass.ProjectMass;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectMass.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PROJECT_MASS_TAB = CREATIVE_MODE_TABS.register("project_mass_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GALVANIZED_SQUARE_STEEL.get()))
                    .title(Component.translatable("creativetab.project_mass_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.GALVANIZED_SQUARE_STEEL.get());
                    })
                    .build());

    public static void register(IEventBus event) {
        CREATIVE_MODE_TABS.register(event);
    }
}
