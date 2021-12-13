# クリックまな板
1.12.2にあったクリックまな板が1.17にもFabricとして帰って来る

![Imgur](https://imgur.com/xsXFHrp.png)

# Mod導入方法 （遊ぶ側、エンドユーザー向け）
- 多分1.17のバニラを一回起動しておく必要があると思います。
    - そうなるとJava 16以降が必要
- Fabricを導入します。
    - https://fabricmc.net/use/
      - FabricLoader のバージョンは`0.12.11`以上が必要です。（くっっそやばい脆弱性の対策のため）
    - Windowsならexeの方でいいんじゃね？
    - exeを起動するとWindows SmartScreenが警戒してきますがそのまま実行
- modsフォルダに以下のファイルを入れます
    - ClickManaita-Fabric-1.17-1.0.0.jar
        - https://www.curseforge.com/minecraft/mc-mods/clickmanaita/files
    - Fabric API 1.17版
        - https://www.curseforge.com/minecraft/mc-mods/fabric-api/files
    - Fabric Language Kotlin 1.17版
        - このMODはKotlinという言語で書かれているためこのファイルが他のFabric製MODとは違い必要になります。
        - https://www.curseforge.com/minecraft/mc-mods/fabric-language-kotlin/files
- Minecarft Lancherで起動構成ををfabric-loader-1.17に変更します
- あとは楽しんで

## 開発者向け

メモ程度の自作ブログ  
https://takusan.negitoro.dev/posts/minecraft_fabric_dev_environment/

### 開発環境
IDEA と Kotlin でできている。  
今回はKotlinで書かれています。

### 必要なもの
- IDEA
- AdoptOpenJDK 16

### 実行方法
- このリポジトリをクローンして、ブランチ：1.17-fabricをチェックアウトします。
- IDEA右上のFileからProject Structureを選択して、JDKのバージョンを16にします。
   - これでできるはずなんだけど、できない場合は下も試して
- IDEAの設定を開き、Build,Execution,Deployment > Build Tools > Gradle へ進み、Gradle JVMを16にします。
- できたら`IDEA`の右上？にいる`Gradle`を押して、`Sync`ボタンを押します。これ

![Imgur](https://imgur.com/0ra6jbW.png)  

- 無事終了したら一旦IDEAを終了させます
- そうしたら再度起動します。すると実行ボタンのところに`Minecraft Client`と書かれているはずです。そしたら再生ボタンを押して起動させます。
- 以上です。

### Jar生成
- IDEA右上のGradleを押して、Tasks>build>build です

### JSONとか
多分Forgeで使ってたJSONがそのまま使えるはず。アイテムID変えてなければ。  
話変わるけどJSONの生成機能使ってる人いるの？微妙に不便じゃねあれ？
