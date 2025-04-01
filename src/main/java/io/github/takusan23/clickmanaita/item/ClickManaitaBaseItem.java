package io.github.takusan23.clickmanaita.item;

import io.github.takusan23.clickmanaita.ClickManaitaItemTool;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

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
     * ツールチップで表示する文字を返す
     *
     * @return NeoForge.EVENT_BUS でツールチップ表示イベントが購読できるので、返り値を追加する
     */
    public MutableComponent getHoverText(ItemStack itemStack) {
        MutableComponent text = Component.literal(toolTipText);
        text.setStyle(Style.EMPTY.withColor(TextColor.parseColor(toolTipColor).getOrThrow()));
        return text;
    }

    /**
     * まな板を右クリックした際の処理。増やす
     * <p>
     * チェストの中身も増えるように
     */
    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {

        // 共通処理を呼び出す
        ClickManaitaItemTool.manaita(
                dropSize,
                p_41427_.getLevel(),
                p_41427_.getClickedPos(),
                p_41427_.getPlayer()
        );

        return InteractionResult.SUCCESS;
    }
}
