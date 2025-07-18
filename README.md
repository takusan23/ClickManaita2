# クリックまな板
NeoForge 1.21.8 版クリックまな板です。  

![Imgur](https://imgur.com/I7llaQs.png)

# ダウンロード
https://www.curseforge.com/minecraft/mc-mods/clickmanaita

Fabric/Forge/NeoForge 版よく確認してください。  
Fabric 版と違い、Forge/NeoForge 版の前提MODはありません。ダウンロードしたらmodsフォルダに入れればいいです。

# Fabric / NeoForge / Forge 版の違い
Fabric / Forge / NeoForge で使いたい MOD があればそれに合わせてダウンロードすればいいと思います。  
機能的な差はなく、アイテムID等も（このMODでは）同じ値を利用しているので、Fabric・Forge・NeoForge の環境を行ったり来たり出来ると思います。

# 導入方法
- Java 21 を入れます！！！
- NeoForge 1.21.8 を入れます
  - https://neoforged.net/
    - NeoForge は`21.8.1-beta`以上が必要です。
- 入れたら、ランチャーから NeoForge を選んで起動します。
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

### Gitのブランチ
`forge`と`fabric`と`neoforge`があります。  
切り替えたあとは一度`IDEA`を閉じて、開き直さないとうまく起動しないと思います！！！。  
あとなんかあったらとりあえず`.idea`、`build`、`run`フォルダを消してみて下さい。

## Fabric版との違い
Fabric版はKotlinで書かれてますが、Forge / NeoForge 版はJavaです。  
アイテムID、ブロックIDは多分変更してないので、Fabric環境 / Forge環境 / NeoForge 環境を行ったり来たり出来ます（他MODは知らんけど）

## 開発環境構築

### 必要なもの
- Java 21
    - 私はEclipse Adoptiumを使った
    - JDKのディストリビューションにこだわりがある場合は別にこれじゃなくてもいいです
      - （NeoForge チームはマイクロソフト製 OpenJDK を推してるらしい）
- IDEA
    - Eclipseはよくわからん

### 実行方法
- 環境変数の設定から、システム環境変数の`JAVA_HOME`が入れた`Eclipse Adoptium`のパスになっているか確認する。
- ついでに`javac -version`して 21 が返ってくるか確認
- このリポジトリをクローンするなり、zipをDLするなりしてソースコードを手に入れます。
    - git cloneした場合はブランチ`1.21.8-neoforge`に切り替えてください。
- IDEAでこのリポジトリを開いてください
- しばらく待ちます
    - ここで Java 21 が指定できてないとコケると思う
    - 私の環境では10分ぐらいかかった。`BUILD SUCCESSFUL in 9m 33s`とかでればおｋ
- Gradle Syncします。`IDEA`の右上？にいる`象さんマーク (Gradle)`を押して、`更新ボタンみたいなやつ (Sync)`を押します。これ
  - 失敗したら `C:\Users\ユーザー名\.gradle\caches` を消すと良いかも

![Imgur](https://imgur.com/0ra6jbW.png)

- 終わったら、再生ボタンの隣りにあるドロップダウンメニューから`Client`が選択可能になってます。`Client`を選択して再生ボタンを押せば起動できます。
- お疲れさまでした

### Minecraft 最新版への追従方法
もっといい方法があれば知りたい

- 一個前のバージョンの NeoForge の方のブランチから、最新版のバージョンでブランチを切る
- 最新版の Minecraft に対応した NeoForge の Mdk をダウンロードしてくる
  - https://neoforged.net/mod-generator/
- Mdk の zip を解凍する
- このディレクトリにファイルを移す
  - gradle / build.gradle / gradle.properties など
- ファイルを移した後、mod_id / mod_authors などの MOD 固有の値を戻す
  - git の差分ですぐ戻せるはず
  - NeoForge のバージョンとかは mdk そのままにしておく
- 開発環境構築の手順を元に Gradle の sync 等をやる
- README を更新する

# トラブルシューティング
- `Error: could not open clientRunVmArgs.txt`
  - `Gradle`の`Tasks > build > clean`したあと`Sync (更新ボタンみたいなやつ)`

## Jar書き出し

1.`gradle.properties`を開きます。  
2.`mod_version=`のところのバージョンを上げます  
3.IDEAの右にある`Gradle (象さんマーク)`から`Tasks > build`と進み、`build`を押します。
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

## レシピ登録
テクスチャ→`resources/assets/clickmanaita/textures`

レシピ→`resources/data/clickmanaita/recipes`

保存先が若干違う（なにこのくそ仕様）
