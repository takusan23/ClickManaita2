# クリックまな板
1.12.2にあったクリックまな板が帰ってきました。

![Imgur](https://imgur.com/LdiN0OX.png)

# ダウンロード
https://www.curseforge.com/minecraft/mc-mods/clickmanaita

# 前作との違い
- まな板つるはしは廃止されました
    - 代わりにまな板エンチャントを追加しました。普通にエンチャント台で引き当てることができます。

# トラブルシューティング
- `runClient`が押せない（なんかバツマーク）
    - `gradlew genIntellijRuns`を再度実行
  
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
  
## Jar書き出し

1.`build.gradle`を開きます。  
2.`version=`のところのバージョンを上げます  
3.IDEAの右にある`Gradle`から`Tasks > build`と進み、`build`を押します。
4.`build/libs/`に`Jar`ファイルができてるはずなので、無くさないように避難させておきましょう

## ブランチ
`master`ブランチは使ってない  
各マイクラバージョンのブランチ名があるのでそっち参照

# その他メモ

## ForgeによるLog4j2の脆弱性に対する対応

https://gist.github.com/TheCurle/f15a6b63ceee3be58bff5e7a97c3a4e6

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