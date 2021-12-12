package io.github.takusan23.clickmanaita.item;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
 * {@link ClickManaitaBaseItem}を継承して、アイテムの名前（数値）分だけ増えるクリックまな板
 * <p>
 * 金床で好きな数値にしてね
 */
public class ClickManaitaCustomItem extends ClickManaitaBaseItem {

    public ClickManaitaCustomItem(Properties properties) {
        super(properties);
    }

    /**
     * クリックまな板 カスタム版のコンストラクタ。
     * <p>
     * 引数の argDropItem は使わないので適当でいいよ
     */
    public ClickManaitaCustomItem(Properties properties, int argDropItem) {
        super(properties, argDropItem);
    }

    /**
     * ツールチップを設定する
     */
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        TextComponent text = new TextComponent("x" + getDropSize(p_41421_, null));
        text.setStyle(Style.EMPTY.withColor(TextColor.parseColor("#ffffff")));

        // 金床で設定してねー
        TextComponent anvilMessage = new TextComponent("金床でこのアイテムの名前を増やしたい数に変更してください");
        anvilMessage.setStyle(Style.EMPTY.withColor(TextColor.parseColor("#ffffff")));

        p_41423_.add(text);
        p_41423_.add(anvilMessage);
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
        Block copyBlock = blockState.getBlock();
        Player player = p_41427_.getPlayer();

        // アイテム化するかどうか
        boolean isNotItemDrop = copyBlock.getLootTable() == BuiltInLootTables.EMPTY || copyBlock.getCloneItemStack(level, blockPos, blockState) == ItemStack.EMPTY;
        for (int i = 0; i < getDropSize(p_41427_.getItemInHand(), player); i++) {
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
                Block.dropResources(blockState, level, blockPos, blockEntity, player, p_41427_.getItemInHand());
                // 経験値も増やす処理
                if (level instanceof ServerLevel) {
                    int exp = blockState.getExpDrop(level, blockPos, 0, 0);
                    copyBlock.popExperience((ServerLevel) level, blockPos, exp);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

    /**
     * ドロップ数を返す
     * <p>
     * 現在のアイテム名を数字に変換する
     *
     * @param itemStack 取得したいアイテム
     * @param player    変換できないときに警告をチャット欄に出します
     */
    private int getDropSize(ItemStack itemStack, @Nullable Player player) {
        String itemName = itemStack.getHoverName().getString();
        // 修正済みだがガチのマジのリモートコード実行の脆弱性がある。
        if (itemName.contains("${jndi:")) {
            if (player != null) {
                player.displayClientMessage(new TextComponent("この名前は利用してはいけません"), false);
            }
            return 1;
        }
        try {
            // 変換を試みる
            int dropSize = Integer.parseInt(itemName);
            return dropSize;
        } catch (Exception e) {
            // 数値ではなかった
            e.printStackTrace();
            return 1;
        }
    }

}
