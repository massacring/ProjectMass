package net.massacring.projectmass.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class BlasterGun extends Item {
    public BlasterGun(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (player == null) return InteractionResult.FAIL;
        player.sendSystemMessage(Component.literal("Pew pew!"));
        return InteractionResult.SUCCESS;
    }
}
