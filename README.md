## java 获取本机连接过的所有WiFI密码
### windows中可以通过cmd命令行输入指令来获取连接过的WiFi名：
> netsh wlan show profiles

```
    所有用户配置文件 : xiaobing
    所有用户配置文件 : TP-LINK_B72F42
    所有用户配置文件 : Smartisan personal hotspot
    所有用户配置文件 : Bjgoodwill
    所有用户配置文件 : Bjgoodwill-Guest
    所有用户配置文件 : darenyu1404
    所有用户配置文件 : IT5G
    所有用户配置文件 : IT
```
 
### 然后可以再次通过输入命令,获取WiFi名为"IT" 的密码:
> netsh wlan show profiles name=IT key=clear

```
接口 WLAN 上的配置文件 IT:
=======================================================================

已应用: 所有用户配置文件

配置文件信息
-------------------
    版本                   : 1
    类型                   : 无线局域网
    名称                   : IT
    控制选项               :
        连接模式           : 自动连接
        网络广播           : 只在网络广播时连接
        AutoSwitch         : 请勿切换到其他网络
        MAC 随机化: 禁用

连接设置
---------------------
    SSID 数目              : 1
    SSID 名称              :“IT”
    网络类型               : 结构
    无线电类型             : [ 任何无线电类型 ]
    供应商扩展名           : 不存在

安全设置
-----------------
    身份验证         : WPA2 - 个人
    密码                 : CCMP
    身份验证         : WPA2 - 个人
    密码                 : 未知
    安全密钥               : 存在
    关键内容            : 1234567890123

费用设置
-------------
    费用                : 无限制
    阻塞                : 否
    接近数据限制        : 否
    过量数据限制        : 否
    漫游                : 否
    费用来源            : 默认
```
