# 点击砧板（ClickManaita）

这是适用于 Minecraft Fabric 26.2 的点击砧板模组。

使用不同等级的点击砧板右击方块，可以按对应倍率生成方块掉落物；模组还提供方块版点击砧板、自定义倍率点击砧板和点击砧板附魔。

![点击砧板演示](https://imgur.com/YHFDbjG.png)

## 运行环境

| 组件 | 最低版本 |
| --- | --- |
| Minecraft | 26.2 |
| Java | 25 |
| Fabric Loader | 0.19.3 |
| Fabric API | 0.155.2+26.2 |
| Fabric Language Kotlin | 1.13.13+kotlin.2.4.10 |

## 安装方法

1. 安装适用于 Minecraft 26.2 的 [Fabric Loader](https://fabricmc.net/use/)，版本不低于 0.19.3。
2. 将以下文件放入游戏的 `mods` 文件夹：
   - [ClickManaita-Fabric](https://www.curseforge.com/minecraft/mc-mods/clickmanaita/files)
   - [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api/files)，版本不低于 `0.155.2+26.2`
   - [Fabric Language Kotlin](https://www.curseforge.com/minecraft/mc-mods/fabric-language-kotlin/files)，版本不低于 `1.13.13+kotlin.2.4.10`
3. 在 Minecraft Launcher 中选择 `fabric-loader-26.2` 启动配置。
4. 启动游戏。

## 开发环境

### 必要工具

- IntelliJ IDEA
- Eclipse Temurin 25 或其他兼容的 JDK 25

项目使用 Kotlin 编写。IDEA 的 Project SDK 和 Gradle JVM 都应设置为 Java 25。

### 获取源码

```powershell
git clone https://github.com/ASPshijiu/ClickManaita2.git
cd ClickManaita2
git switch codex/fabric-26.2
```

### 常用命令

Windows PowerShell：

```powershell
# 构建发布 JAR
.\gradlew.bat clean build

# 启动开发客户端
.\gradlew.bat runClient

# 启动开发服务端
.\gradlew.bat runServer
```

Linux 或 macOS 请将 `.\gradlew.bat` 替换为 `./gradlew`。

构建产物位于 `build/libs/`。

如果 IDEA 同步后没有出现 `Minecraft Client` 和 `Minecraft Server` 运行配置，请关闭并重新打开 IDEA。仍无法解决时，可以删除 `.idea`、`.gradle`、`build` 和 `run` 后重新同步项目。

### 多人游戏测试

1. 同时启动 `Minecraft Client` 和 `Minecraft Server`。
2. 在客户端添加地址为 `localhost` 的服务器。
3. 加入服务器并测试物品、方块和附魔行为。

## Fabric 26.2 适配内容

- Minecraft：`26.2`
- Fabric Loader：`0.19.3`
- Fabric API：`0.155.2+26.2`
- Fabric Loom：`1.17.16`
- Gradle：`9.5.1`
- Kotlin：`2.4.10`
- Fabric Language Kotlin：`1.13.13+kotlin.2.4.10`
- 将 26.2 中已移除的 `BlockPos.center` 调整为 `Vec3.atCenterOf(blockPos)`。
- 更新 `fabric.mod.json`、构建产物名称和开发说明。

已验证完整 Gradle 构建以及 Minecraft 26.2 客户端启动和资源加载。项目目前没有自动化测试；存档内的右击复制、附魔和多人游戏仍建议在发布前手动回归。

## 适配后续 Minecraft 版本

1. 阅读 [Fabric 官方博客](https://fabricmc.net/blog/)中的版本迁移说明。
2. 对照 [Fabric Example Mod](https://github.com/FabricMC/fabric-example-mod) 的目标版本分支。
3. 从 [Fabric 开发页面](https://fabricmc.net/develop/)更新 Minecraft、Loader、Loom 和 Fabric API 版本。
4. 从 [Fabric Language Kotlin](https://github.com/FabricMC/fabric-language-kotlin)更新 Kotlin 依赖。
5. 更新 Gradle Wrapper、`fabric.mod.json` 和本 README。
6. 执行完整构建，并分别验证客户端和服务端启动。

Minecraft 已提供官方未混淆代码，因此不再需要额外生成或下载反混淆源码。

## 生成发布 JAR

### 本地构建

```powershell
.\gradlew.bat clean build
```

发布 JAR 和源码 JAR 会生成在 `build/libs/`。

### GitHub Actions

仓库提供手动触发的 `Make Publish Jar File` 工作流：

1. 在 GitHub 仓库的 Actions 页面选择该工作流。
2. 选择要构建的分支并点击运行。
3. 构建完成后下载 Artifact，并在任务摘要中核对哈希值。

工作流引用的第三方 Action 应继续使用固定提交哈希，避免标签被替换导致供应链风险。

Windows 可以使用 PowerShell 校验下载文件：

```powershell
Get-FileHash .\ClickManaita-Fabric-26.2-1.0.0.jar -Algorithm SHA256
```

## 常见问题

### `NoClassDefFoundError: joptsimple/OptionSpec`

如果同时出现 `Unsupported access widener format (v2)`，请先在 IDEA 中执行 `File > Invalidate Caches...`，然后重新同步 Gradle。

### `Failed to read accessWidener file from mod fabric-content-registries-v0`

刷新依赖后重新构建：

```powershell
.\gradlew.bat --refresh-dependencies
```

### JVM 内存不足

如果日志出现 `There is insufficient memory for the Java Runtime Environment to continue`，请检查可用内存和系统盘剩余空间。必要时调整 `gradle.properties` 中的 `org.gradle.jvmargs`。

### 其他启动或同步问题

关闭 IDEA，删除 `.idea`、`.gradle`、`build` 和 `run`，然后重新打开项目并同步 Gradle。

## 许可证

本项目使用 [Apache License 2.0](LICENSE)。
