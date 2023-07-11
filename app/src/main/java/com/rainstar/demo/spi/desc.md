# Spi
  * SPI即Service Provider Interfaces.
  * 有时候一个接口可能有多种实现方式, 如果将特定实现写死在代码里面, 那么要更换实现的时候就要改动代码, 对原有代码进行重写. 这样非常麻烦, 而且也容易导致bug. Java提供了一种方式, 让我们可以对接口的实现进行动态替换, 这就是SPI机制. SPI机制非常简单, 步骤如下:
  * 定义接口 
  * 定义接口的实现 
  * 创建resources/META-INF/services目录 
  * 在上一步创建的目录下创建一个以接口名(类的全名) 命名的文件, 文件的内容是实现类的类名 (类的全名), 如:
  * 在services目录下创建的文件是com.rainstar.demo.spi.SpiDemoInterface 文件中的内容为SpiDemoInterface接口的实现类, com.rainstar.demo.spi.java.SpiDemoInterfaceImpl1
  * 使用ServiceLoader查找接口的实现.
