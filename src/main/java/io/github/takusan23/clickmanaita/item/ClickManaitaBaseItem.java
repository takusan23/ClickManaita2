package io.github.takusan23.clickmanaita.item;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import javax.annotation.Nullable;
import java.util.List;

/**
 * クリックまな板はこのクラスを継承して作る
 */
public class ClickManaitaBaseItem extends Item {

    /**
     * ドロップ数
     */
    private int dropSize = 2;

    /**
     * Tooltipに表示する文字列
     */
    private String toolTipText = "";

    /**
     * Tooltipの文字の色
     */
    private String toolTipColor = "";

    /**
     * コンストラクタは引数が二個ある方を使ってください
     * <p>
     * 引数が二個ある方を利用してください。
     */
    @Deprecated
    public ClickManaitaBaseItem(Item.Properties properties) {
        super(properties);
    }

    /**
     * コンストラクタ。
     *
     * @param properties  クリエイティブタブの設定など
     * @param argDropItem ドロップ数
     */
    public ClickManaitaBaseItem(Item.Properties properties, int argDropItem) {
        super(properties);
        // ドロップ数設定
        dropSize = argDropItem;
        // Tooltipテキスト
        toolTipText = "x" + argDropItem;
    }

    /**
     * ツールチップのテキストを設定する
     *
     * @param toolTipText 表示させたい文字列
     */
    public void setToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
    }

    /**
     * ツールチップの色を設定する
     *
     * @param toolTipColor 色。カラーコードで #252525 など
     */
    public void setToolTipColor(String toolTipColor) {
        this.toolTipColor = toolTipColor;
    }

    /**
     * まな板を右クリックした際の処理。増やす
     * <p>
     * チェストの中身も増えるように
     */
    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        Level level = p_41427_.getLevel();
        BlockPos blockPos = p_41427_.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        Player player = p_41427_.getPlayer();
        Block copyBlock = blockState.getBlock();
        // アイテム化するかどうか
        boolean isNotItemDrop = copyBlock.getLootTable() == BuiltInLootTables.EMPTY || copyBlock.getCloneItemStack(blockState, null, level, blockPos, player) == ItemStack.EMPTY;
        for (int i = 0; i < dropSize; i++) {
            // アイテム化しない場合
            if (isNotItemDrop) {
                ItemStack copyItem = new ItemStack(copyBlock.asItem());
                // NBTタグを移す
                if (blockEntity != null) {
                    CompoundTag compoundTag = blockEntity.serializeNBT();
                    if (!compoundTag.isEmpty()) {
                        copyItem.addTagElement("BlockEntityTag", compoundTag.copy());
                    }
                }
                // アイテムを地面に生成
                Block.popResource(level, blockPos, copyItem);
            }
            // チェストの中身も増やす
            if (blockEntity instanceof Container) {
                for (int l = 0; l < ((Container) blockEntity).getContainerSize(); l++) {
                    Block.popResource(level, blockPos, ((Container) blockEntity).getItem(l).copy());
                }
            }
            // ブロック複製
            if (player != null) {
                copyBlock.playerDestroy(level, player, blockPos, blockState, blockEntity, player.getMainHandItem());
                // なんか経験値を吐き出す実装がなくなった？ので自前で用意
                if (level instanceof ServerLevel) {
                    int exp = blockState.getExpDrop(level, level.random, blockPos, 0, 0);
                    copyBlock.popExperience((ServerLevel) level, blockPos, exp);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return super.onItemUseFirst(stack, context);
    }

    /**
     * ツールチップを表示させる。
     */
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        MutableComponent text = Component.literal(toolTipText);
        text.setStyle(Style.EMPTY.withColor(TextColor.parseColor(toolTipColor).get().orThrow()));
        p_41423_.add(text);
    }

}
