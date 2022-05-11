package net.kyrptonaught.servercustomportals.mixin;

import eu.pb4.polymer.api.block.PolymerBlock;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.networking.ForcePlacePortalPacket;
import net.kyrptonaught.customportalapi.util.CustomPortalHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CustomPortalBlock.class)
public class VirtualPortalBlock implements PolymerBlock {

    @Override
    public Block getPolymerBlock(BlockState state) {
        return Blocks.NETHER_PORTAL;
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        Direction.Axis dir = CustomPortalHelper.getAxisFrom(state);
        return this.getPolymerBlock(state).getDefaultState().with(NetherPortalBlock.AXIS, dir);
    }

    @Override
    public void onPolymerBlockSend(ServerPlayerEntity player, BlockPos.Mutable pos, BlockState blockState) {
        ForcePlacePortalPacket.sendForcePacket(player, pos);
    }
}
