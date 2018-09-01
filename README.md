### 电影租赁管理系统的实现

#### 环境配置
1. 开发工具idea，数据库mysql，表是mysql数据库自带的sakila表。
2. 数据库的配置在resources文件夹中dbconfig.properties中,把数据库的密码修改即可

jdbc.jdbcUrl=jdbc:mysql://localhost:3306/sakila
jdbc.driverClass=com.mysql.jdbc.Driver
jdbc.user=root
jdbc.password=123456



导入方法：打开IDEA，import导入项目，选中pom.xml文件，一直next，导入项目后会自动安装依赖。大概等上几分钟的时间，配置Tomcat运行即可。




#### 实现的功能
##### 1. 拦截器功能，拒绝未登录用户进入系统
如果用户没有登陆，那么就只能访问http://localhost:8080/start.html页面。
可以用空白页面测试一下：http://localhost:8080/Film.html，如果用户没有登陆，会直接来到start登陆页面。
所以开始运行项目的时候，可以随便选一个html页面点击运行，因为没有登陆的用户都是会跳转到登陆页面的。

##### 2. 登录功能
访问路径：http://localhost:8080/start.html
用户名为customer表的first_name字段，密码为customer表的last_name字段。

例如：账号  mary  密码 smith

对用户名和密码都进行了相应的校验。如果用户和密码在数据库里存在，那么验证通过，则跳转到主页。
否则会弹出窗口，提示登陆失败

##### 3.主页的功能菜单
我用了一个bootstrap的Collapse插件。
首先进入index主页面，是看不到查询的表数据的。
点击左上角的功能菜单< Customer管理 >这个蓝色的按钮，就会显示出主页面了！！！！！！！
点击Film这个选项，就会跳转到一个空白的页面。

##### 4. 分页功能
实现了分页功能，可以点击页面查询到相应的数据
当前页面为第一页时，无法点击上一页
当前页面为最后一页时，无法点击下一页。

##### 5. 对customer的新增、编辑、删除功能

新增和编辑的功能都对first_name、last_name、email进行了校验，不能输入空值，
email必须符合邮箱地址的格式才行。
例子：  123456789@qq.com  这个就符合地址要求
新增和编辑功能都是弹出模态框进行操作的。
当新增完成后，系统会自动跳转到新增的那行数据出现的页面。
删除功能以弹出提示框的方式进行操作。
如果有外键约束，就会根据coustomer_id先删除外键关联的Payment和rental两个表中对应的数据库。
然后再删除coustomer表中的数据，这样系统就不会报错

##### 6. 退出系统功能
点击页面的右上角的按钮退出系统
退出系统时会清空session的值和一些本地数据。
退出系统后会返回到登录界面，此时需要重新登录才能访问主界面。

# 
