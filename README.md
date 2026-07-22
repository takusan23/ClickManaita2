# 点击砧板（ClickManaita）

适用于 **Minecraft Fabric 26.2** 的点击砧板模组。它保留点击砧板的方块复制玩法，并提供一套面向娱乐和单人测试的高数值砧板装备。

![点击砧板演示](https://imgur.com/YHFDbjG.png)

> [!WARNING]
> 砧板装备故意采用极高数值：全套护甲可免疫常规伤害，武器与工具数值远高于原版。它不适合平衡生存、PVP 或公共服务器；多人使用前请取得服务器管理者同意。

## 功能

### 点击砧板

- 提供木、石、铁、金、钻石、绿宝石和自定义倍率的点击砧板。
- 使用点击砧板右击方块，会按该砧板的倍率生成对应方块掉落物。
- 包含可放置的砧板方块、自定义倍率砧板与点击砧板附魔。

### 砧板神装

所有新装备均不可损坏、耐火、稀有度为史诗，并提供简体中文、英语和日语名称及提示。

#### 护甲

每件砧板护甲具备：

- `2000` 护甲值、`2000` 护甲韧性、`100%` 击退抗性。
- 所有适用的原版护甲附魔均为 **255 级**；包含互斥的保护类附魔。新合成、创造栏取得和 `/give` 取得的物品均自带这些附魔。

部位能力：

| 部位 | 单件能力 |
| --- | --- |
| 砧板头盔 | 补满氧气、饱食度与饱和度，并持续提供夜视。 |
| 砧板胸甲 | 持续清除有害状态。 |
| 砧板护腿 | 自动灭火；潜行时隐身。 |
| 砧板靴子 | 速度 III。 |

穿齐四件砧板护甲后，服务端会赋予飞行，并持续提供抗性 IV、再生 X、力量 X、急迫 X、跳跃提升 V、生命提升 X、吸收伤害 X、抗火、水下呼吸、缓降、海豚的恩惠与幸运 X；同时取消该玩家受到的伤害。

#### 武器与弓

| 物品 | 基础能力 |
| --- | --- |
| 砧板剑 | 约 `100000` 攻击伤害，适用武器附魔均为 255 级。 |
| 砧板神剑 | 约 `1000000` 攻击伤害，适用武器附魔均为 255 级。 |
| 砧板弓 | 箭矢基础伤害 `100000`，适用弓附魔均为 255 级。 |

剑类附带锋利、亡灵杀手、节肢杀手、击退、火焰附加、抢夺、横扫之刃、耐久与经验修补等适用附魔。弓附带力量、冲击、火矢、无限、耐久与经验修补等适用附魔。

#### 工具

砧板镐、斧、铲、锄、万能工具与剪刀均具有约 `100000` 采掘速度、约 `2000000` 耐久，并自带效率、时运、精准采集、耐久与经验修补等适用的 255 级附魔。

手持砧板采掘工具潜行挖掘时，会以被挖方块为中心处理 `3×3×3` 范围内可被该工具高效采掘的方块。

## 合成与外观

- 除砧板神剑与砧板万能工具外，每件新装备可用 **一块绿宝石制点击砧板** 与对应原版物品在工作台无序合成。
- 护甲使用对应下界合金护甲；弓和剪刀使用对应原版物品。
- 砧板神剑由砧板剑与下界之星合成。
- 砧板万能工具由砧板镐、砧板斧、砧板铲和砧板锄合成。
- 装备暂复用原版下界合金或对应工具的模型与穿戴外观；本项目未搬运第三方模组贴图。

## 运行环境

| 组件 | 版本 |
| --- | --- |
| Minecraft | 26.2 |
| Java | 25 |
| Fabric Loader | 0.19.3 或更高 |
| Fabric API | 0.155.2+26.2 或更高 |
| Fabric Language Kotlin | 1.13.13+kotlin.2.4.10 或更高 |

## 安装

1. 安装 [Fabric Loader](https://fabricmc.net/use/) 26.2 版本。
2. 将本模组 JAR、[Fabric API](https://modrinth.com/mod/fabric-api) 与 [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin) 放入游戏 `mods` 目录。
3. 使用 Fabric 26.2 启动游戏。

## 测试与使用

旧存档中已经存在的砧板装备不会自动补上新属性或默认附魔。请重新合成，或使用以下命令取得新物品：

```mcfunction
/give @s clickmanaita:manaita_helmet
/give @s clickmanaita:manaita_chestplate
/give @s clickmanaita:manaita_leggings
/give @s clickmanaita:manaita_boots
/give @s clickmanaita:manaita_sword
/give @s clickmanaita:manaita_god_sword
/give @s clickmanaita:manaita_bow
```

可通过 `/item replace` 将护甲直接放入对应槽位，例如：

```mcfunction
/item replace entity @s armor.head with clickmanaita:manaita_helmet
```

## 开发

```powershell
# 完整构建
.\gradlew.bat clean build

# 启动开发客户端
.\gradlew.bat runClient

# 启动开发服务端
.\gradlew.bat runServer
```

构建产物位于 `build/libs/`。Linux 或 macOS 请使用 `./gradlew`。

本次适配已验证完整 Gradle 构建、资源 JSON 解析与 Fabric 26.2 客户端资源加载。游戏内神装效果应使用新生成的物品在单人世界或受控测试服务器中验证。

## 功能参考与许可证

补齐装备功能时参考了 [manaita_plus_neo](https://github.com/baizeli/manaita_plus_neo) 和 [ManaitaPlus-Legacy](https://github.com/RealSenPhent/ManaitaPlus-Legacy) 的公开功能范围。当前 Fabric 26.2 实现使用原生 Minecraft 与 Fabric API 接口重新编写，未复制 `manaita_plus_neo` 的 AGPL-3.0 代码或资源。

本项目采用 [Apache License 2.0](LICENSE)。
