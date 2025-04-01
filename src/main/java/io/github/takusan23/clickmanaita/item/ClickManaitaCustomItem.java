package io.github.takusan23.clickmanaita.item;

import io.github.takusan23.clickmanaita.ClickManaitaItemTool;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;

import java.util.function.Consumer;

/**
 * {@link ClickManaitaBaseItem}を継承して、アイテムの名前（数値）分だけ増えるクリックまな板
 * <p>
 * 金床で好きな数値にしてね
 */
public class ClickManaitaCustomItem extends ClickManaitaBaseItem {

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
    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        // 継承元は使わないので super はコメントアウト
        // super.appendHoverText(p_41421_, p_339594_, p_399753_, p_399884_, p_41424_);

        MutableComponent text = Component.literal("x" + getDropSize(p_41421_));
        text.setStyle(Style.EMPTY.withColor(TextColor.parseColor("#FFFFFF").getOrThrow()));

        // 金床で設定してねー
        MutableComponent anvilMessage = Component.literal("金床でこのアイテムの名前を増やしたい数に変更してください");
        anvilMessage.setStyle(Style.EMPTY.withColor(TextColor.parseColor("#FFFFFF").getOrThrow()));

        p_399884_.accept(text);
        p_399884_.accept(anvilMessage);
    }

    /**
     * まな板を右クリックした際の処理。増やす
     * <p>
     * チェストの中身も増えるように
     */
    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {

        // 共通処理を呼び出す
        int dropSize = getDropSize(p_41427_.getItemInHand());
        ClickManaitaItemTool.manaita(
                dropSize,
                p_41427_.getLevel(),
                p_41427_.getClickedPos(),
                p_41427_.getPlayer()
        );

        return InteractionResult.SUCCESS;
    }

    /**
     * ドロップ数を返す
     * <p>
     * 現在のアイテム名を数字に変換する
     *
     * @param itemStack 取得したいアイテム
     */
    private int getDropSize(ItemStack itemStack) {
        String itemName = itemStack.getHoverName().getString();
        try {
            // 変換を試みる
            int dropSize = Integer.parseInt(itemName);
            return dropSize;
        } catch (NumberFormatException e) {
            // 数値ではなかった
            // e.printStackTrace();
            return 1;
        }
    }

}
