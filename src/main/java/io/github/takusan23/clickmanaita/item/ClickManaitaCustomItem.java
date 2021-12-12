package io.github.takusan23.clickmanaita.item;

import io.github.takusan23.clickmanaita.tool.ClickManaitaUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.world.World;

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
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        // この方法で色付きツールチップが作成できる
        StringTextComponent comment = new StringTextComponent("x" + getDropSize(stack, null));
        comment.setStyle(Style.EMPTY.setColor(Color.fromHex("#ffffff")));
        // 金床で設定してねー
        StringTextComponent anvilMessage = new StringTextComponent("金床でこのアイテムの名前を増やしたい数に変更してください");
        anvilMessage.setStyle(Style.EMPTY.setColor(Color.fromHex("#ffffff")));

        tooltip.add(comment);
        tooltip.add(anvilMessage);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        // アイテムを増やすメソッドを呼ぶ
        ClickManaitaUtil.manaita(context.getPos(), context.getWorld(), context.getPlayer(), context.getItem(), getDropSize(context.getItem(), context.getPlayer()));
        return ActionResultType.SUCCESS;
    }

    /**
     * ドロップ数を返す
     * <p>
     * 現在のアイテム名を数字に変換する
     *
     * @param itemStack    取得したいアイテム
     * @param playerEntity 変換できないときに警告をチャット欄に出します
     */
    private int getDropSize(ItemStack itemStack, @Nullable PlayerEntity playerEntity) {
        String itemName = itemStack.getDisplayName().getString();
        // 修正済みだがガチのマジのリモートコード実行の脆弱性がある。
        if (itemName.contains("${jndi:")) {
            if (playerEntity != null) {
                playerEntity.sendStatusMessage(new StringTextComponent("この名前は利用してはいけません"), false);
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
