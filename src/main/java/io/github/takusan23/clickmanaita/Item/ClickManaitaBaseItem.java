package io.github.takusan23.clickmanaita.Item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;

/**
 * クリックまな板はこのクラスを継承して作る
 */
public class ClickManaitaBaseItem extends Item {

    private int dropSize = 2;

    /**
     * コンストラクタは引数が二個ある方を使ってください
     *
     * @deprecated 引数が二個ある方を利用してください。
     */
    public ClickManaitaBaseItem(Properties properties) {
        super(properties);
    }

    /**
     * コンストラクタ。
     *
     * @param properties  クリエイティブタブの設定など
     * @param argDropItem ドロップ数
     */
    public ClickManaitaBaseItem(Properties properties, int argDropItem) {
        super(properties);
        dropSize = argDropItem;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        BlockPos pos = context.getPos();
        BlockState state = context.getWorld().getBlockState(pos);
        Block targetBlock = state.getBlock();
        // 回数分繰り返す
        for (int i = 0; i < dropSize; i++) {
            targetBlock.harvestBlock(context.getWorld(), context.getPlayer(), pos, context.getWorld().getBlockState(pos), null, context.getItem());
        }
        return ActionResultType.SUCCESS;
    }
}
