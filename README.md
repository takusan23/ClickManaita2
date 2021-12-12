# クリックまな板
1.12.2版のソースコードです（だいたい3年前）。
メンテするのしんどいから最新のForge要求するように書き換えただけ。それ以外は記念に残しておく  
最新のForgeを最低条件にすることで、`log4j2`のめっちゃやばい脆弱性による被害を減らせたらなと。
最新版の`IntelliJ IDEA`で開発環境構築ができるようにしました。

# ダウンロード
https://www.curseforge.com/minecraft/mc-mods/clickmanaita

**Forgeは1.12.2のLatestの方を入れて下さい。**  
（このMODに限らず、過去のバージョンのForgeを導入する際は脆弱性に対して対策が入った`Latest`の方を利用することを強くおすすめします。）

最新のForgeじゃない場合は以下のエラーが出ます

![Imgur](https://imgur.com/XZfUzXe.png)

# 開発者向け

## ForgeによるLog4j2の脆弱性に対する対応

https://gist.github.com/TheCurle/f15a6b63ceee3be58bff5e7a97c3a4e6

## 開発環境構築

### 必要なもの
- Java 8
- IDEA
    
### 実行方法
- JDK 8を入れます
- このリポジトリをクローンするなり、zipをDLするなりしてソースコードを手に入れます。
    - git cloneした場合はブランチ`1.12.2-forge`に切り替えてください。
- IDEAでこのリポジトリを開いてください
- しばらく待ちます
- IDEA右上にある`Gradle`から、`Tasks > forgegradle runs > genIntellijRuns`をダブルクリックしてまた待つ
- Gradle Syncします。`IDEA`の右上？にいる`Gradle`を押して、`Sync`ボタンを押します。これ
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

# その他メモ
## 最新版 IntelliJ IDEA？ で resources フォルダ自体がなかったことにされる問題

https://www.tntmodders.com/tutorial/item-1122/

`build.gradle`の最後に書き足します。

```gradle
copy {
    delete {
        delete "$buildDir/classes/java/main"
    }
    into "$buildDir/classes/java/main"
    from sourceSets.main.resources
}
```
