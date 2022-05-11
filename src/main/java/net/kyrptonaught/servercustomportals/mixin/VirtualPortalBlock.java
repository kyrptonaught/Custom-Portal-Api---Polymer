package net.kyrptonaught.servercustomportals.mixin;

import eu.pb4.polymer.api.block.PolymerBlock;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CustomPortalBlock.class)
public class VirtualPortalBlock implements PolymerBlock {

    @Override
    public Block getPolymerBlock(BlockState state) {
        return Blocks.NETHER_PORTAL;
    }
}
