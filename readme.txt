zuul自帶ribbon的負載均衡功能

本工程中使用了groovy，這種語言具有動態性。可以隨時通過修改代碼來動態修改業務邏輯，而不必重啟服務。

對比圖1和2的區別在於，1中的EnableZuulProxy支持全部的過濾器，而2中黑掉的是EnableZuulServer不支持的過濾器
正因為有些過濾器不支持，所以它的性能會略高