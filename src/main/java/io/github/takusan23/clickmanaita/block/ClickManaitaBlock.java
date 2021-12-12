package io.github.takusan23.clickmanaita.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

/**
 * クリックまな板ブロック
 * <p>
 * コンストラクタは引数が二個ある方を利用してください
 */
public class ClickManaitaBlock extends Block {

    /**
     * ドロップ数
     */
    private int dropSize = 2;

    /**
     * @deprecated 引数が二個ある方を利用してね
     */
    public ClickManaitaBlock(Properties properties) {
        super(properties);
    }

    /**
     * @param properties  クリエイティブタブの設定など
     * @param argDropSize どろっぷする個数
     */
    public ClickManaitaBlock(Properties properties, int argDropSize) {
        super(properties);
        dropSize = argDropSize;
    }

    /**
     * 右クリックしたとき。まな板の本命機能
     *
     * なんか非推奨になってるんだけど何？
     */
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            for (int i = 0; i < dropSize; i++) {
                // 現在持ってるアイテムを取得する
                ItemStack currentItem = player.inventory.getCurrentItem().copy();
                // 一個だけ
                currentItem.setCount(1);
                // アイテムを地面に生成
                spawnAsEntity(worldIn, pos, currentItem);
            }
            return ActionResultType.CONSUME;
        }
    }
}
