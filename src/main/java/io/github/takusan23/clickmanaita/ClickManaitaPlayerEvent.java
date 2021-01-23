package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.Enchant.RegisterEnchant;
import io.github.takusan23.clickmanaita.Tool.ClickManaitaUtil;
import net.minecraft.enchantment.EnchantmentHelper;
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
     */
    @SubscribeEvent
    public void onBlockRightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        // エンチャントレベル取得
        int enchantLevel = EnchantmentHelper.getEnchantmentLevel(RegisterEnchant.clickManaitaEnchant, event.getItemStack());
        // チェスト等インベントリを持つアイテムででスニーク状態じゃない場合はreturn
        if (event.getWorld().getBlockState(event.getPos()).hasTileEntity() && !event.getPlayer().isSneaking()) {
            return;
        }
        if (enchantLevel > 0) {
            // まな板発動
            switch (enchantLevel) {
                case 1:
                    ClickManaitaUtil.manaita(event.getPos(), event.getWorld(), event.getPlayer(), event.getItemStack(), 2);
                    break;
                case 2:
                    ClickManaitaUtil.manaita(event.getPos(), event.getWorld(), event.getPlayer(), event.getItemStack(), 4);
                    break;
                case 3:
                    ClickManaitaUtil.manaita(event.getPos(), event.getWorld(), event.getPlayer(), event.getItemStack(), 8);
                    break;
                case 4:
                    ClickManaitaUtil.manaita(event.getPos(), event.getWorld(), event.getPlayer(), event.getItemStack(), 16);
                    break;
                case 5:
                    ClickManaitaUtil.manaita(event.getPos(), event.getWorld(), event.getPlayer(), event.getItemStack(), 32);
                    break;
            }
        }
    }


}
