# クリックまな板
1.18のFabricがリリースされたのでクリックまな板対応しました。  
Y座標がマイナスって何！？

![Imgur](https://imgur.com/0Ys4rZu.png)

# Mod導入方法 （遊ぶ側、エンドユーザー向け）
- Java 17 以降が必要です！！！
- 多分1.18のバニラを一回起動しておく必要があると思います。
- Fabricを導入します。
    - https://fabricmc.net/use/
      - FabricLoaderのバージョンは`0.12.11`以降にしてください。
    - Windowsならexeの方でいいんじゃね？
    - exeを起動するとWindows SmartScreenが警戒してきますがそのまま実行
- modsフォルダに以下のファイルを入れます
    - ClickManaita-Fabric-1.18-1.0.0.jar
        - https://www.curseforge.com/minecraft/mc-mods/clickmanaita/files
    - Fabric API 1.18版
        - https://www.curseforge.com/minecraft/mc-mods/fabric-api/files
    - Fabric Language Kotlin 1.18版
        - このMODはKotlinという言語で書かれているためこのファイルが他のFabric製MODとは違い必要になります。
        - https://www.curseforge.com/minecraft/mc-mods/fabric-language-kotlin/files
          - `Fabric Language Kotlin 1.7.0+kotlin.1.6.0`
- Minecarft Lancherで起動構成ををfabric-loader-1.18に変更します
- あとは楽しんで

## 開発者向け

メモ程度の自作ブログ  
https://takusan.negitoro.dev/posts/minecraft_fabric_dev_environment/

移行作業のメモ
https://takusan.negitoro.dev/posts/minecraft_mod_1_18_migration/

### Gitのブランチ
forgeとfabricがあります。  
切り替えたあとは一度`IDEA`を閉じて、開き直さないとうまく起動しないと思います！！！。  
あとなんかあったらとりあえず`.idea`を消してみて下さい。

### 開発環境
IDEA と Kotlin でできている。  
今回はKotlinで書かれています。

### 必要なもの
- IDEA
- Eclipse Adoptium 17
  - Java 17 以降が必要です
  - JDKのディストリビューションにこだわりがある場合は別にこれじゃなくてもいいです

### 実行方法
- このリポジトリをクローンして、ブランチ：1.18-fabricをチェックアウトします。
- IDEA右上のFileからProject Structureを選択して、JDKのバージョンを17にします。
   - これでできるはずなんだけど、できない場合は下も試して
- IDEAの設定を開き、Build,Execution,Deployment > Build Tools > Gradle へ進み、Gradle JVMを17にします。
- できたら`IDEA`の右上？にいる`Gradle`を押して、`Sync`ボタンを押します。これ

![Imgur](https://imgur.com/0ra6jbW.png)  

- 無事終了したら一旦IDEAを終了させます
- そうしたら再度起動します。すると実行ボタンのところに`Minecraft Client`と書かれているはずです。そしたら再生ボタンを押して起動させます。
- 以上です。

### トラブルシューティング
```
Exception in thread "main" java.lang.NoClassDefFoundError: joptsimple/OptionSpec
Caused by: java.lang.RuntimeException: Unsupported access widener format (v2)
```

- 私の場合はIDEAのキャッシュを消したら直りました。
  - IDEAの左上にあるFileから、`Invalidate Caches...`を選択して、そのままボタンを押します。

```
Failed to read accessWidener file from mod fabric-content-registries-v0
```

- コマンドプロンプトで`gradlew --refresh-dependencies`を実行したら治った

```
# There is insufficient memory for the Java Runtime Environment to continue.
# Native memory allocation (malloc) failed to allocate 1162736 bytes for Chunk::new
# An error report file with more information is saved as:
```

- メモリ不足です
  - Cドライブ不足だったかもしれない

### Jar生成
- IDEA右上のGradleを押して、Tasks>build>build です  
- `build/libs`の中にあります

### JSONとか
多分Forgeで使ってたJSONがそのまま使えるはず。アイテムID変えてなければ。  
話変わるけどJSONの生成機能使ってる人いるの？微妙に不便じゃねあれ？
