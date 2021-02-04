# クリックまな板
1.12.2にあったクリックまな板が帰ってきました。

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

# その他メモ

## IDEA設定
- `Ctrl`+クリックの時の検索は🔧マーク押して`Scope`を`All Places`にするといいかも

## レシピ登録
テクスチャ→`resources/assets/clickmanaita/textures`

レシピ→`resources/data/clickmanaita/recipes`

保存先が若干違う（なにこのくそ仕様）