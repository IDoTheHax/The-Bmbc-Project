package net.matty.bmbc.block.custom;

import net.matty.bmbc.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class C4Block extends Block {
    public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;
    public C4Block(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(UNSTABLE, Boolean.valueOf(false)));
    }

    private static final VoxelShape SHAPE =
            Block.box(3, 0, 1, 13, 3, 15);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pOldState.is(pState.getBlock())) {
            if (pLevel.hasNeighborSignal(pPos)) {
                pLevel.removeBlock(pPos, false);
            }

        }
    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if (pLevel.hasNeighborSignal(pPos)) {
            pLevel.removeBlock(pPos, false);
        }
    }


    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    public static void explode(Level pLevel, BlockPos pPos) {
        explode(pLevel, pPos, (LivingEntity)null);
    }

    private static void explode(Level pLevel, BlockPos pPos, @Nullable LivingEntity pEntity) {
        if (!pLevel.isClientSide) {
            PrimedTnt primedtnt = new PrimedTnt(pLevel, (double)pPos.getX() + 0.5D, (double)pPos.getY(), (double)pPos.getZ() + 0.5D, pEntity);
            pLevel.addFreshEntity(primedtnt);
            pLevel.playSound((Player)null, primedtnt.getX(), primedtnt.getY(), primedtnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            pLevel.gameEvent(pEntity, GameEvent.PRIME_FUSE, pPos);
        }
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!itemstack.is(ModItems.C4_DETONATOR.get())) {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        } else {
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 11);
            Item item = itemstack.getItem();
            //if (!pPlayer.isCreative()) {
            //    if (itemstack.is(ModItems.C4_DETONATOR.get())) {
            //        itemstack.hurtAndBreak(1, pPlayer, (p_57425_) -> {
            //            p_57425_.broadcastBreakEvent(pHand);
            //        });
            //    } else {
            //        itemstack.shrink(1);
            //    }
            //}

            pPlayer.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }

    public boolean dropFromExplosion(Explosion pExplosion) {
        return false;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(UNSTABLE);
    }
}
