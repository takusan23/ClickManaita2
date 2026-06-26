# クリックまな板
26.2 のFabricがリリースされたのでクリックまな板対応しました。  

![Imgur](https://imgur.com/YHFDbjG.png)

# Mod導入方法 （遊ぶ側、エンドユーザー向け）
- Fabricを導入します。
    - https://fabricmc.net/use/
      - FabricLoaderのバージョンは`0.19.3`以降にしてください。
    - Windowsならexeの方でいいんじゃね？
    - exeを起動するとWindows SmartScreenが警戒してきますがそのまま実行
- modsフォルダに以下のファイルを入れます
    - ClickManaita-Fabric 本体
        - https://www.curseforge.com/minecraft/mc-mods/clickmanaita/files
    - Fabric API
        - https://www.curseforge.com/minecraft/mc-mods/fabric-api/files
          - `fabric-api-0.153.0+26.2` 以降
    - Fabric Language Kotlin 26.2 版
        - このMODはKotlinという言語で書かれているためこのファイルが他のFabric製MODとは違い必要になります。
        - https://www.curseforge.com/minecraft/mc-mods/fabric-language-kotlin/files
          - `fabric-language-kotlin-1.13.12+kotlin.2.4.0` 以降
- Minecarft Lancher で起動構成を fabric-loader-26.2 に変更します
- あとは楽しんで

## 開発者向け

メモ程度の自作ブログ  
https://takusan.negitoro.dev/posts/minecraft_fabric_dev_environment/

### Gitのブランチ
forgeとfabricがあります。  
切り替えたあとは一度`IDEA`を閉じて、開き直さないとうまく起動しないと思います！！！。  
あとなんかあったらとりあえず`.idea`、`build`、`run`フォルダを消してみて下さい。

### 開発環境
IDEA と Kotlin でできている。  
今回はKotlinで書かれています。

### 必要なもの
- IDEA
- Eclipse Temurin 25
  - Java 25 以降が必要です
  - JDK のディストリビューションにこだわりがある場合は別にこれじゃなくてもいいです

### 実行方法
- このリポジトリをクローンして、ブランチ：26.2-fabricをチェックアウトします。
- IDEA右上のFileからProject Structureを選択して、JDKのバージョンを 21 にします。
   - これでできるはずなんだけど、できない場合は下も試して
- IDEAの設定を開き、Build,Execution,Deployment > Build Tools > Gradle へ進み、Gradle JVM を 21 にします。
- できたら`IDEA`の右上？にいる`Gradle`を押して、`Sync`ボタンを押します。これ

![Imgur](https://imgur.com/0ra6jbW.png)  

- 無事終了したら一旦 IDEA を終了させます
- そうしたら再度起動します。すると実行ボタンのところに`Minecraft Client`と書かれているはずです。そしたら再生ボタンを押して起動させます。
- 以上です。初回実行時はなんかナレーターが喋りだすのでびっくりしないようにしてください・・・

#### マルチプレイの動作確認
- `Minecraft Client`と`Minecraft Server`を起動する
- アドレス`localhost`でサーバーを追加する
- 入る

### Minecraft 最新版への追従方法

- Fabric の場合、新しいバージョンが出るたびに内部の変更点をわかりやすく書いてくれるので、目を通す
  - https://fabricmc.net/blog/
  - サンプルも追従してくれるので、コミット差分を見ると参考になる
    - https://github.com/FabricMC/fabric-example-mod
- gradle.properties を最新の値にする
  - 以下のリンクから、それぞれの値を最新にする
    - https://fabricmc.net/develop/
  - fabric-language-kotlin だけは別
    - https://github.com/FabricMC/fabric-language-kotlin
- Gradle の更新もあればそれも更新
  - build.gradle もあれば 
- fabric.mod.json も更新する
- 実行方法を参照して Gradle sync 等する
- README も更新する

### Minecraft のソース生成
Minecraft バニラが難読化されなくなったため不要になりました。

### Jar生成（配布するMODのファイル生成）
MinecraftのMOD利用者/開発者？を狙ったウィルスから身を守るため、このMODでは配布するMODファイル（jarファイル）を`GitHub Actions (CI/CD)`で作っています。  
が、今のところMODファイルの生成までしかしないので、ローカルに落として配布サイトへアップロードするとあんまり意味がないかもしれないです・・・。  
また、MODファイルのハッシュ値を出すようにしたので、これで改ざんされていない事を確認できます。

`GitHub Actions`を使う前に、利用している`アクション`のバージョン指定がコミットハッシュになっていることを確認してください。  
バージョン指定である場合はコミットハッシュを使うように書き直してください。

#### GitHub Actions で作成
`1.20-fabric`、`1.20-forge`以降は`GitHub Actions`でMODファイルを作成できます。  
ブランチを選んで手動実行ボタンを押せばいいです。  
![image](https://github.com/takusan23/ClickManaita2/assets/32033405/ac87cda2-ec4d-42aa-a239-42107c2ce101)

また、GitHubにログインすることでハッシュ値も確認できます。  
![image](https://github.com/takusan23/ClickManaita2/assets/32033405/860dfc63-141b-4960-b04d-f01a62728026)

Windowsの場合は`PowerShell`を使うことでハッシュ値が同じかどうか確認できます。同じ文字列（16進数）がでてきた場合は改ざんされていません。  
（`Get-FileHash`コマンドだとアルファベットが大文字になってしまいますが、16進数は大文字小文字は区別されないので問題ないです。）  
![image](https://github.com/takusan23/ClickManaita2/assets/32033405/7af7c31a-caa9-43ee-b393-88758082af9e)

どうしても心配な方は試してみてください。

#### 手動でJar作成
- IDEA右上のGradleを押して、Tasks>build>build です  
- `build/libs`の中にあります

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

そのほか

- `.idea` `build` `run` フォルダを消して開き直してみる

### JSONとか
多分Forgeで使ってたJSONがそのまま使えるはず。アイテムID変えてなければ。  
話変わるけどJSONの生成機能使ってる人いるの？微妙に不便じゃねあれ？
