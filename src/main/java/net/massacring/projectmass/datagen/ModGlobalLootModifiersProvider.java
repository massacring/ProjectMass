package net.massacring.projectmass.datagen;

import net.massacring.projectmass.ProjectMass;
import net.massacring.projectmass.items.ModItems;
import net.massacring.projectmass.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ProjectMass.MOD_ID);
    }

    @Override
    protected void start() {
        add("primitive_blaster", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                //LootItemRandomChanceCondition.randomChance(0.35f).build()
        }, ModItems.PRIMITIVE_BLASTER.get()));
    }
}
