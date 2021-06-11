# クリックまな板
1.12.2にあったクリックまな板が1.17にもFabricとして帰って来る予定（時間がなくてできるか怪しい）

![Imgur](https://imgur.com/xsXFHrp.png)

## 開発者向け

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
- できたら`Load Gradle Changes`ボタンを探して押します。🐘さんのアイコン
- 無事終了したら一旦IDEAを終了させます
- そうしたら再度起動します。すると実行ボタンのところに`Minecraft Client`と書かれているはずです。そしたら再生ボタンを押して起動させます。
- 以上です。