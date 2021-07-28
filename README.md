# クリックまな板
Forge 1.17.1がリリースされていたので対応しました。

![Imgur](https://imgur.com/ZMqBqpH.png)

# ダウンロード
https://www.curseforge.com/minecraft/mc-mods/clickmanaita

Fabric/Forge版よく確認してください。

# Fabric版の違い
基本的な機能はある。クリックまな板エンチャントとか一部の機能はFabricにはない。  
Forgeで他に入れたいMODがある場合（Optifine入れてシェーダーパックつかいたい！みたいな）があればForgeだし、  
逆にFabricで入れたいMODがあればFabricを選べばいいです。

# 導入方法
- Java 16を入れます。
  - 私は`AdoptOpenJDK`を入れます
- バニラの1.17.1を起動します
    - バニラアイスって喉乾くから抹茶のほうが好き
- Forge 1.17.1を入れます
  - https://files.minecraftforge.net/net/minecraftforge/forge/
- 入れたら、ランチャーからForge 1.17.1を選んで起動します。
  - modsフォルダ内に他のバージョンのmodが入ってないか確認してね
- 起動します
- modsフォルダが出来ていると思うのでその中に上記のリンクからダウンロードしたクリックまな板のMODファイルを入れます
- もう一度起動したら多分導入できていると思います

# 前作との違い
- まな板つるはしは廃止されました
    - 代わりにまな板エンチャントを追加しました。普通にエンチャント台で引き当てることができます。
  
# 開発者向け
## マルチプレイ動作確認
- EULAに同意する(`eula.txt`)
- `server.properties`を書き換える
   - `gamemode=creative`
     - クリエイティブ
   - `online-mode=false`
     - 正規版チェックを無効化
- できたら`runServer`を実行する

なんか`なんちゃらProxy`みたいなのは書かなくてよくなったみたい。

## Fabric版の違い
Fabric版はKotlinで書かれてますが、Forge版はJavaです。

## 開発環境構築

### 必要なもの
- Java 16
    - Gradleのバージョンが7になったので多分必要
    - 私はAdoptOpenJDKを使った
- IDEA
    - Eclipseはよくわからん
    
### 実行方法
- 環境変数の設定から、システム環境変数の`JAVA_HOME`が入れた`AdoptOpenJDK`のパスになっているか確認する。
- ついでに`javac -version`して16が返ってくるか確認
- このリポジトリをクローンするなり、zipをDLするなりしてソースコードを手に入れます。
    - git cloneした場合はブランチ`1.17.1-forge`に切り替えてください。
- IDEAでこのリポジトリを開いてください
- しばらく待ちます
    - ここでJava 16が指定できてないとコケると思う
    - あとインターネットが遅い？と`Tag mismatch!`でコケると思う。これ意味不明すぎで草
    - 私の環境では10分ぐらいかかった。`BUILD SUCCESSFUL in 9m 33s`とかでればおｋ
- IDEA右上にある`Gradle`から、`Tasks > forgegradle runs > genIntellijRuns`をダブルクリックしてまた待つ
- 終わったら、再生ボタンの隣りにあるドロップダウンメニューから`runClient`が選択可能になってます。`runClient`を選択して再生ボタンを押せば起動できます。
- お疲れさまでした


# トラブルシューティング
- `runClient`が押せない（なんかバツマーク）
    - `gradlew genIntellijRuns`を再度実行
    
## Jar書き出し

1.`build.gradle`を開きます。  
2.`version=`のところのバージョンを上げます  
3.IDEAの右にある`Gradle`から`Tasks > build`と進み、`build`を押します。
4.`build/libs/`に`Jar`ファイルができてるはずなので、無くさないように避難させておきましょう

## ブランチ
`master`ブランチは使ってない  
各マイクラバージョンのブランチ名があるのでそっち参照

# その他メモ

## IDEA設定
- `Ctrl`+クリックの時の検索は🔧マーク押して`Scope`を`All Places`にするといいかも

## Gitで他のブランチのフォルダの中身を今のブランチにコピーする

`git checkout ブランチ名 フォルダパス`

例：ブランチ名「1.16.4」の`src/main`フォルダを今のブランチにコピー

`git checkout 1.16.4 src/main`

## 他のバージョンへ対応

`mods.toml`の`versionRange`と`versionRange`と`loaderVersion`を直す？

`Java`もメソッド名が変わってる可能性があるので直す。

## レシピ登録
テクスチャ→`resources/assets/clickmanaita/textures`

レシピ→`resources/data/clickmanaita/recipes`

保存先が若干違う（なにこのくそ仕様）