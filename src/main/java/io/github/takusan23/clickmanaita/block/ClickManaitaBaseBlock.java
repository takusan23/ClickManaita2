package io.github.takusan23.clickmanaita.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

/**
 * クリックまな板ブロック
 * <p>
 * コンストラクタは引数が二個ある方を利用してください
 */
public class ClickManaitaBaseBlock extends Block {

    /**
     * ドロップ数
     */
    private int dropSize = 2;

    /**
     * 引数が二個ある方を利用してね
     */
    @Deprecated
    public ClickManaitaBaseBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    /**
     * @param properties  クリエイティブタブの設定など
     * @param argDropSize どろっぷする個数
     */
    public ClickManaitaBaseBlock(BlockBehaviour.Properties properties, int argDropSize) {
        super(properties);
        dropSize = argDropSize;
    }

    /**
     * 右クリックしたとき。まな板の本命機能
     * <p>
     * なんか非推奨になってるんだけど何？
     */
    @Override
    public @NotNull InteractionResult use(BlockState p_57450_, Level p_57451_, BlockPos p_57452_, Player p_57453_, InteractionHand p_57454_, BlockHitResult p_57455_) {
        for (int i = 0; i < dropSize; i++) {
            // 現在持ってるアイテムをコピーする
            ItemStack currentItem = p_57453_.getMainHandItem().copy();
            // 一個だけ
            currentItem.setCount(1);
            // アイテムを地面に生成
            Block.popResource(p_57451_, p_57452_, currentItem);
        }
        return InteractionResult.SUCCESS;
    }
}
