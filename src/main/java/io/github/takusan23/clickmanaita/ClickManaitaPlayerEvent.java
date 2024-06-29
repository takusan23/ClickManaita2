package io.github.takusan23.clickmanaita;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * プレイヤーがアイテムを拾ったなど、イベントを受け取るクラス
 * <p>
 * どうやら、引数のクラス（なんちゃらEvent）ってのが大事らしく、メソッド名はどうでもよいらしい（ただしアクセス修飾子はpublicにする）
 * <p>
 * MinecraftForge.EVENT_BUS.register()で登録できます
 */
public class ClickManaitaPlayerEvent {

    /**
     * 右クリックイベントを取る
     * <p>
     * todo なんでか知らんけど右クリックイベントがclient/server共に２回呼ばれるんだけど？
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onBlockRightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        // TODO エンチャント再実装
/*
        // エンチャントレベル取得
        int enchantLevel = EnchantmentHelper.getEnchantmentLevel(RegisterEnchant.CLICKMANAITA_ENCHANT.get(), event.getEntity());
        // チェスト等インベントリを持つアイテムででスニーク状態じゃない場合はreturn
        if (event.getLevel().getBlockState(event.getPos()).hasBlockEntity() && !event.getEntity().isShiftKeyDown()) {
            return;
        }
        if (enchantLevel > 0) {
            // Java 16以降この書き方ができる模様
            int dropSize = switch (enchantLevel) {
                case 1 -> 2;
                case 2 -> 4;
                case 3 -> 8;
                case 4 -> 16;
                case 5 -> 32;
                default -> 0;
            };

            // まな板発動
            // 共通処理を呼び出す
            ClickManaitaItemTool.manaita(
                    dropSize,
                    event.getLevel(),
                    event.getPos(),
                    event.getEntity()
            );
        }
*/
    }

}
