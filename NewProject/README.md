# SSM框架学习

##--个人网站后台开发

##### 软件架构：

基于流行SSM框架：Spring+SpringMVC+Mybatis

WEB页面设计：Bootstrap

项目配置：	使用Maven进行项目jar导入

​			使用Git进行版本控制，并将每次编写的代码上传到Gitee进行保存

##### 环境需求：

​	Eclipse（装有Web相关插件以及Maven插件和Git插件）

​	Navcat（mysql 5.7 图形化管理工具）

​	JDK 1.8

##### 环境配置

​	Eclipse中的Maven配置，Git配置，请自行查阅，网上有相关资源

##### 参考网站：

Maven Repository : https://mvnrepository.com/

Gitee：https://gitee.com/

Gitee 项目仓库：https://gitee.com/xuzhi7162/SSM

GitHub项目仓库：https://github.com/xuzhi7162/SSM/tree/master/NewProject/JavaWebTest 

（使用IntelliJ IDEA尝试开发）

Mybatis教程：https://blog.csdn.net/hellozpc/article/details/80878563#3Mybaits_109 

## Mybatis

#### 日志工具

##引入相关依赖

```xml
<!-- log4j日志依赖 -->
	<dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>1.2.17</version>
    </dependency>
```

##在全局配置文件中添加相应的setting设置

```xml
<settings>
		<!-- 添加日志相关setting配置，目的是在控制台能够看出打印日志，可以看到执行的SQL语句 -->
		<setting name="logImpl" value="LOG4J"/>
</settings>
```

##在resources目录下建立log4j.properties配置文件，并在内部做出相应修改

```properties
# Global logging configuration
log4j.rootLogger=ERROR, stdout
# MyBatis logging configuration...
log4j.logger.com.xuzhi.mapper=DEBUG
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```

###修改内容如下

官方语句为

```properties
log4j.logger.org.mybatis.example.BlogMapper.selectBlog=TRACE
```

修改为

```properties
log4j.logger.com.xuzhi.mapper=DEBUG
```

即将原先的org.mybatis.example.BlogMapper.selectBlog修改为你mapper所在的包，并将后面的TRACE修改为DEBUG以便于在控制台打印

#### mybatis-config.xml

##Mybatis的全局配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?> 
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<properties>
		<property name="driver" value="com.mysql.jdbc.Driver"/>
		<property name="url" value="jdbc:mysql://localhost:3306/mybatis"/>
		<property name="username" value="root"/>
		<property name="password" value="xuzhi7162"/>
	</properties>
    <settings>
		<!-- 添加日志相关setting配置，目的是在控制台能够看出打印日志，可以看到执行的SQL语句 -->
		<setting name="logImpl" value="LOG4J"/>
	</settings>
	<environments default="mybatis">
		<!-- 可以配置多个environment环境，但是每个环境都必须拥有其唯一的id识别，不可重复，default用来选择某一个具体的environment环境，变量值为id的值 -->
		<environment id="mybatis">
			<transactionManager type="JDBC" />
			<dataSource type="UNPOOLED">
				<property name="driver" value="${driver}" />
				<property name="url" value="${url}" />
				<property name="username" value="${username}" />
				<property name="password" value="${password}" />
			</dataSource>
		</environment>
	</environments>
	<!-- 添加Mybatis的配置文件，具体实体类对应具体配置文件，注意：添加路径时必须使用"/"，不能使用"." -->
	<mappers>
		<!-- 还有其他方法，常用的就以下两种，多推荐第二种，
						否则当有很多个mapper接口时配置文件会变得较为冗长 -->
		<!-- 方法一：直接引入某个mapper接口的具体配置文件 -->
		<mapper resource="com/xuzhi/mapper/UserInfoMapper.xml" />
		<!-- 方法二：直接引入mapper接口所在的包，以后只要在该包下的mapper接口都可直接使用，不需要再				重新引入  -->
		<package name="com/xuzhi/po"/>
	</mappers>
</configuration>
```

##两种mapper引入方法：直接引入配置文件，引入实体类所在的包

#### UserInfoMapper.xml

##UserInfoMapper实体类的配置文件，该配置文件必须在全局配置文件**mybatis.cfg,xml**中注册

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace必须指定到相应的mapper接口，可以用"."连接 -->
<mapper namespace="com.xuzhi.mapper.UserInfoMapper">
	<!-- 插入操作 -->
	<insert id="insert" parameterType="com.xuzhi.po.UserInfo">
		insert into user_info(user_name,user_pass,user_phone) values(#{userName},#		{userPass},#{userPhone})
	</insert>
</mapper>
```

##对相应数据表的GRUD操作的语句都写于该配置文件中，

**#{}和${}**

#{} 只是替换？，相当于PreparedStatement使用占位符去替换参数，可以防止sql注入。
${} 是进行字符串拼接，相当于sql语句中的Statement，使用字符串去拼接sql；$可以是sql中的任一部分传入到Statement中，不能防止sql注入。

注：所谓SQL注入，就是通过把SQL命令插入到Web[表单](https://baike.baidu.com/item/%E8%A1%A8%E5%8D%95/5380322)提交或输入域名或页面请求的查询字符串，最终达到欺骗服务器执行恶意的SQL命令。具体来说，它是利用现有应用程序，将（恶意的）SQL命令注入到后台数据库引擎执行的能力，它可以通过在Web表单中输入（恶意）SQL语句得到一个存在安全漏洞的网站上的数据库，而不是按照设计者意图去执行SQL语句。

#### MybatisUtil.java工具类

##用与返回SqlSession

```java
package com.xuzhi.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *  单例类，在程序中仅有一个类
 * @author 绪志
 *
 */
public class MybatisUtil {
	 private static SqlSessionFactory sqlSessionFactory;
	 /**
	   *   静态代码块，在程序的所有运行过程中，该代码块仅执行一次，类似于单例
	  */
	    static {
	    	//指定全局配置文件
	        String resource="mybatis.cfg.xml";
	        InputStream in=null;
	        try {
	        	//读取配置文件
	            in = Resources.getResourceAsStream(resource);
	            //构建SqlSessionFactory
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            if(in != null){
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	    public static SqlSession getSession(){
	    	//返回SqlSession
	        return sqlSessionFactory.openSession();
	    }
}
```

#### UserInfoMapper.java

```java
package com.xuzhi.mapper;

import com.xuzhi.po.UserInfo;
/**
 * 该接口中主要是对UserInfo实体类的GRUD操作，不需要实现该接口，仅需要在UserInfoMapper.xml中添加相应的sql语句既可
 * @author 绪志
 *
 */
public interface UserInfoMapper {
	int insert(UserInfo userInfo);
}
```

#### SQL语句

##### select复合查询语句

##推荐使用注解方法 **@Param（）**

```java
/**
     * 通过name和flower进行复合查询，通过注解可以在mapper的配置文件中直接使用#{name}和#{flower}来接收参数
     * 否则必须使用mybatis默认的参数接收方式，param1，param2或者arg0,arg1
     * 推荐使用注解的方式来进行传递参数
     * @param name
     * @param flower
     * @return
     */
    Girl queryByNameFlower(@Param("name") String name,@Param("flower") String flower);
```

##通过就Javabean进行参数传递

```java
/**
     * 通过javabean来传递参数
     * mapper.xml中调用参数时只需要使用实体类中的属性名即可
     * @param girl
     * @return
     */
    Girl queryByNameFlower1(Girl girl);
```

###在传入多个javabean时，在接收参数时可以使用param1.XXX，此方法是不友好的，可以在定义方法时使用@Param注解，

例：@Param（“a”） Girl girl==========使用时可以使用"a.XXX"

##通过hashmap进行参数传递(在mapper中按照键的名称取值）

```java
/**
     * 通过hashmap传参
     * @return
     */
    Girl queryByNameFlower2(Map<String,Object> map);
```

#### 动态SQL

##本部分没有做测试类，完全摘自Mybatis官方文档

- if

- choose (when, otherwise)

- trim (where, set)

- foreach

- bind

- sql

  ​        

##### if   

动态 SQL 通常要做的事情是根据条件包含 where 子句的一部分。比如：

```xml
<select id="findActiveBlogLike" resultType="Blog">
  SELECT * FROM BLOG 
  <where> 
    <if test="state != null">
        AND state = #{state}
    </if> 
    <if test="title != null">
        AND title like #{title}
    </if>
    <if test="author != null and author.name != null">
        AND author_name like #{author.name}
    </if>
  </where>
</select>
```

##在使用where条件是可以使用专门的<where>标签，从而使mybatis自动处理查询条件前面的‘and’关键字，推荐在所有的if语句中所有的查询关键字前面都加上and关键字，即使是第一个<if>在其内容中也要加入and关键字，因为mybatis会帮我们处理好这个and关键字，例如

```xml
<where> 
    <if test="state != null">
        AND state = #{state}
    </if> 
</where>
```

##### choose, when, otherwise

##有时我们不想应用到所有的条件语句，而只想从中择其一项。针对这种情况，MyBatis 提供了 choose 元素，它有点像 Java 中的 switch 语句。

```xml
<select id="findActiveBlogLike"
     resultType="Blog">
  SELECT * FROM BLOG WHERE state = ‘ACTIVE’
  <choose>
    <when test="title != null">
      AND title like #{title}
    </when>
    <when test="author != null and author.name != null">
      AND author_name like #{author.name}
    </when>
    <otherwise>
      AND featured = 1
    </otherwise>
  </choose>
</select>
```

##### trim, where, set

<where>标签代码同<if>标签内的代码

<trim>标签可以看成为<where>的自定义标签，可以通过内部的某些属性来处理AND/OR，还可以处理“，”

```xml
<trim prefix="WHERE" prefixOverrides="AND |OR ">
  ... 
</trim>
```

###官方文档没有完全给出<trim>标签内的所有属性，具体使用时需要具体百度

<set>标签可以处理<if>标签中多余的“，”,例如update中的set后项目的“，”

```xml
<update id="updateAuthorIfNecessary">
  update Author
    <set>
      <if test="username != null">username=#{username},</if>
      <if test="password != null">password=#{password},</if>
      <if test="email != null">email=#{email},</if>
      <if test="bio != null">bio=#{bio},</if>
    </set>
  where id=#{id}
</update>
```

###同<where>标签处理AND/OR一样，可以在每个语句的后面都填上“，”,<set>标签都可以帮我们处理掉

##### foreach

```xml
<select id="selectPostIn" resultType="domain.blog.Post">
  SELECT *
  FROM POST P
  WHERE ID in
  <foreach item="item" index="index" collection="list" open="(" separator="," 					close=")">
        #{item}
  </foreach>
</select>
```

​	· item：自命名，用来表示需要遍历的集合的其中的一个子项

​	·index：当前遍历到的下标

​	·collection：需要遍历的类型   #list、set、map

​	·open：以什么为开始

​	·separator：每个子项之间用什么符号分隔开

​	·close：以什么为结尾

上述代码可“编译出”,

```sql
select * from post p where ID in (a,b,c,d)
```

[^]: 仅作为参考，实际编译出的并不为此

##### bind

###`bind` 元素可以从 OGNL 表达式中创建一个变量并将其绑定到上下文。比如：

```xml
<select id="selectBlogsLike" resultType="Blog">
  <bind name="pattern" value="'%' + _parameter.getTitle() + '%'" />
  SELECT * FROM BLOG
  WHERE title LIKE #{pattern}
</select>
```

[^注]: 多用于模糊查询

##### sql

这个元素可以被用来定义可重用的 SQL 代码段，可以包含在其他语句中。它可以被静态地(在加载参数) 参数化. 不同的属性值通过包含的实例变化. 比如：

```xml
<sql id="userColumns"> ${alias}.id,${alias}.username,${alias}.password </sql>
```

这个 SQL 片段可以被包含在其他语句中，例如：

```xml
<select id="selectUsers" resultType="map">
  select
    <include refid="userColumns"><property name="alias" value="t1"/></include>,
    <include refid="userColumns"><property name="alias" value="t2"/></include>
  from some_table t1
    cross join some_table t2
</select>
```

#### Mybatis关系映射

##使用mybatis处理一般的单表时常使用resultType属性，但是用mybatis处理多表查询时，使用resultType进行结果集的封装不太适用，所以此时要使用自定义封装结果集，多使用resultMap进行自定义结果集的封装

##### **一对一关系映射**

##简要说明，一对一举例，一个用户拥有自己独特的个人信息，一个用户对应一个用户详情信息

<方法一：使用assocation进行具体对象的封装>

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xuzhi.mapper.GirlDetailMapper">

    <!--
        对应一般的单表查询，我们用mybatis的resultType就可以解决
        但是对于多表联合查询我们就需要使用resultMap来进行详细描述返回值处理
    -->
    <!--可以变编写一个父resultMap，子resultMap可以继承父resultMap，以减少重复代码量
        在子resultMap中增加extends=“父id”就可以使用父resultMap
    -->
    <resultMap id="BaseGirlDetail" type="com.xuzhi.model.GirlDetail">
        <id property="id" column="uid" />
        <result property="name" column="name" />
        <result property="flower" column="flower" />
        <result property="birthday" column="birthday" />
    </resultMap>

    <!--封装方式一：使用assocation-->
    <resultMap id="GirlWithDetailMap" type="com.xuzhi.model.GirlDetail">
        <id property="id" column="uid" />
        <result property="name" column="name" />
        <result property="flower" column="flower" />
        <result property="birthday" column="birthday" />
        <association property="girlWithDetail" javaType="com.xuzhi.model.GirlWithDetail">
            <id property="gid" column="gdid" />
            <result property="address" column="address" />
        </association>
    </resultMap>
    <!--封装方式二：使用；连缀方式-->
    <resultMap id="GirlWithDetailMap2" type="com.xuzhi.model.GirlDetail">
        <id property="id" column="uid" />
        <result property="name" column="name" />
        <result property="flower" column="flower" />
        <result property="birthday" column="birthday" />
        <!--连缀写法  "XXX.xx"-->
        <result property="girlWithDetail.gid" column="gdid" />
        <result property="girlWithDetail.address" column="address" />
    </resultMap>

    <!--封装方式三
        支持分步查询，如果有的查询过于复杂，可以使用分步查询的方法进行查询
        extends属性表示使用父resultMap
    -->
    <resultMap id="GirlWithDetailMap3" extends="BaseGirlDetail" type="com.xuzhi.model.GirlDetail">
        <!--
            对于复杂的javabean属性，则由我们自己处理（及返回结果集中的某一个属性是具体的javabean）
            完场第一次查询后会调用assocation中select调用的查询，讲将结果封装到相应的javabean并赋值给property，完成查询
            column属性表示一级查询到的某一列的值作为参数传给二级查询条件
        -->
        <association property="girlWithDetail" select="com.xuzhi.mapper.GirlWithDetailMapper.queryById" column="uid">
        </association>
    </resultMap>


    <select id="queryById" resultMap="GirlWithDetailMap2">
        select t1.id as uid,t1.`name`,t1.flower,t1.birthday,t2.id as gdid, t2.address
        from girl t1,girl_detail t2
        <where>
            t1.id=t2.gid
            and t1.id=#{id}
        </where>
    </select>
    <!--多表联合查询-->
    <select id="queryByIdByStep" resultMap="GirlWithDetailMap3">
        select t1.id as uid,t1.`name`,t1.flower,t1.birthday
        from girl t1
        <where>
            and t1.id=#{id}
        </where>
    </select>
</mapper>
```

##对于javabean的封装多使用oop思想

**Girl.java**

```java
package com.xuzhi.model;

import java.io.Serializable;
import java.util.Date;

public class Girl implements Serializable {
    private long id;
    private String name;
    private String flower;
    private Date birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Girl(String name, String flower){
        this.name=name;
        this.flower=flower;
    }
    public Girl(){

    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flower='" + flower + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
```

**GirlWithDetail.java**

```java
package com.xuzhi.model;

import java.io.Serializable;

public class GirlWithDetail implements Serializable {
    private Integer gid;
    private String address;
    private Girl girl;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "GirlWithDetail{" +
                "gid=" + gid +
                ", address='" + address + '\'' +
                '}';
    }
}

```

**GirlDetail.java**

```java
package com.xuzhi.model;

import java.io.Serializable;

public class GirlDetail extends Girl{
    private GirlWithDetail girlWithDetail;

    public GirlWithDetail getGirlWithDetail() {
        return girlWithDetail;
    }

    public void setGirlWithDetail(GirlWithDetail girlWithDetail) {
        this.girlWithDetail = girlWithDetail;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", flower='" + getFlower() + '\'' +
                ", birthday=" + getBirthday() +
                '}'+
                "GirlDetail{" +
                "girlWithDetail=" + girlWithDetail +
                '}';
    }
}

```



##### 一对多关系映射

##一对多关系映射举例：一个用户可以写多篇博客

##废话不多说，几段代码可以说明一切

**GirlWithBlogMapper.xml**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xuzhi.mapper.GirlWithBlogMapper">

    <resultMap id="BaseGirlDetail" type="com.xuzhi.model.GirlDetail">
        <id property="id" column="gid" />
        <result property="name" column="name" />
        <result property="flower" column="flower" />
        <result property="birthday" column="birthday" />
    </resultMap>
    <resultMap id="girlWithBlogMap" extends="BaseGirlDetail" type="com.xuzhi.model.GirlBlog" >
        <!--ofType是用来描述集合中元素的数据类型-->
        <collection property="blog" ofType="com.xuzhi.model.Blog">
            <id property="id" column="bid" />
            <result property="title" column="title" />
            <result property="summary" column="summary" />
            <result property="content" column="blogContent" />
            <collection property="comments" ofType="com.xuzhi.model.Comment">
                <id  property="id" column="cid"/>
                <result property="content" column="commentContent" />
            </collection>
    </collection>
    </resultMap>
    <select id="queryByIdWithBlog" resultMap="girlWithBlogMap">
        SELECT t1.id as gid,t1.`name`,t1.flower,t1.birthday,
        t2.id as bid,t2.title,t2.summary,t2.content as blogContent,
        t3.id as cid,t3.content as commentContent
        from girl t1,blog t2,`comment` t3
        <where>
            t1.id=t2.g_id
            and t2.id=t3.b_id
            and t1.id=#{id}
        </where>
    </select>
</mapper>
```

**Blog.java**

```java
package com.xuzhi.model;


import java.util.List;

public class Blog {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private Girl girl;
    private List<Comment> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", girl=" + girl +
                ", comments=" + comments +
                '}';
    }
}

```

**Comment.java**

```java
package com.xuzhi.model;

public class Comment {
    private Integer id;
    private String content;
    private Blog blog;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}

```

**GirlBlog.java**

```java
package com.xuzhi.model;

import java.util.List;

public class GirlBlog extends Girl {
    private List<Blog> blog;

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return  "Girl{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", flower='" + getFlower() + '\'' +
                ", birthday=" + getBirthday() +
                '}'+
                "GirlBlog{" +
                "blog=" + blog +
                '}';
    }
}

```

###简要说明：

​	在该例中，一个Girl用户可以拥有多个Blog，一个Blog又可以拥有多个Comment，这就构成了简单的一对多关系，其中还是使用了oop思想，最终想要封装的结果集类型是GirlBlog类型，在该类型包含了用户的部分个人信息，还包括了该用户的Blog，在每个Blog中有包含了该Blog所拥有的Comment，在Blog和GirlBlog中分别使用了List<Comment>和List<Blog>来反应一对多关系

### Spring

#### 基础技术

- java
- 反射
- xml
- xml解析
- 代理
- 大量设计模式 

#### 环境搭建

​	1、添加spring依赖

​	2、编写一个spring的配置文件

​	3、通过spring的应用程序上下文对象获取对象

##### 环境配置测试

**spring全局配置文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans
        xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd ">
    <!--将对象的创建交给spring容器，在这个配置文件里面去声明我需要什么文件
        class:写java类的全限定类名，他是通过全类名然后使用反射的技术进行创建的
        id：ID就是给这个对象在整个应用程序上下文当中去个名以方便区分
    -->
    <bean class="com.xuzhi.pojo.Girl" id="girl">

    </bean>

</beans>
```

**bean类**

###**Girl.java**

```java
package com.xuzhi.pojo;

public class Girl {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```

###测试类-->**SpringTest.java**

```java
package com.xuzhi.spring;

import com.xuzhi.pojo.Girl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test1(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        //在引入配置文件的时候，可以同时引入多个配置文件，在ClassPathXmlApplicationContext中使用String数组作为参数
        /* 例：ApplicationContext ctx=
        	new ClassPathXmlApplicationContext(new String[]{"xxx1.xml","xxx2.xml"});
        */
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2、通过这个对象来获取girl
        Girl girl= (Girl) ctx.getBean("girl");
        //因为后面指定了class，所以不需要进行强制类型转换（个人感觉这种方式比较好）
        //Girl girl =ctx.getBean("girl",Girl.class);
        System.out.println(girl);
    }
}

```

#####   普通代码编写与spring方式编写的

​	普通的获取对象的方式，所有的对象之间的依赖，类之间的依赖关系都是在java代码里面维护的，很难维护的，如果说我们有替换方案，替换比较困难

​	对象的产生全部是在配置里面完成的，其实我们想分析关系，直接在配置文件里面就看出来了。

##### 核心内容学习

- IOC
- AOP​	

**IOC概念（依赖注入）：**

​	控制反转（inverse of contril ）：什么控制，谁反转了谁

​	控制：创建对象，彼此关系的权利

​	普通方式：控制权是在开发人员在程序代码当中进行掌控，new

​	spring方式：夺取控制权，反转给spring的容器

​	**反转过程：**

​		声明要什么

​		spring容器来进行具体的控制

​	依赖注入：

​		依赖：

​	容器

​		![å®¹å¨é­æ¯](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/images/container-magic.png)

​		pojos：自己定义的这些类

​		metadata：在spring的配置文件里面写的这些就是元数据

​		实例化容器：classpath...将配置文件传入，实例化完毕

##### 	值的注入

​		setter()方法注入（最常用的方法）

​			必须其字段有对应的setter（）方法才可完成

​			通过property子节点完成注入

​		构造注入

##### bean元素探讨

​	属性探讨

abstract：该bean将无法被实例化

parent：指定它的父bean是谁，将会继承父bean的所有内容，通过id进行指引

destroy-method：指定这个bean最后销毁的时候一定执行的方法，适合于清理型工作，触发条件是必须bean确实是被销毁才生效

​	容器close被触发

​	refresh也会触发

​	过时的destroy也可以触发

init-method：指定bean的初始化方法，准备性的工作

name：别名，可以通过他一样获取，可以写多个，彼此分割可以使用多种分隔符，空格，逗号等等，

```xml
<bean class="com.xuzhi.pojo.Girl" id="girl" abstract="true" destroy-method="clearDress" init-method="dress" name="g1,g2,g3">
        <!--name指定要注入的属性名称，value给其赋值-->
        <property name="name" value="myFirends" />
 </bean>
```

注：clearDress是Girl类里面的一个方法名，dress也是如此，

scope：指定范围

​	singleton：单例，在spring上下文当中，只有一个实例

​	prototype：原型，要一个就给一个

lazy-init：true就是spring一上来不会直接初始化我们的bean，当我们需要使用它的时候，spring才会初始化

​	直接初始化

​		当应用程序启动会慢一点，内存消耗会更大一点

​		当我们使用bean的时候会快一些

​	延迟初始化

​		程序启动快一些，内存消耗更小一点

​		使用bean会慢一点

depends-on：依赖的bean，如果某一个bean的使用严重依赖于另外一个bean的准备的话，就可以配置depends-on

对于非字面值可以描述的值的注入问题

```xml
	<bean id="pay" class="com.xuzhi.spring.AliPay">

    </bean>
    <bean id="girl" class="com.xuzhi.pojo.Girl" >
        <!--非字面值可描述的属性注入，必须通过ref来描述-->
        <property name="pay" ref="pay" />
    </bean>
```

通过ref指向另外一个bean的ID

关于在spring的配置文件当中单独定义别名

​	alias标签完成

spring多个配置文件里面的bean是可以相互引用的（被上下文扫描到的前提下）



构造注入：

**构造注入方式一：**

```xml
<!--构造注入方式一：
            通过名字来注入
    -->
    <bean id="car" class="com.xuzhi.pojo.Car">
        <constructor-arg name="name" value="宝马" />
        <constructor-arg name="price" value="12123123123" />
        <constructor-arg name="speed" value="123123" />
    </bean>
```

**构造注入方式二：**（不推荐使用，实在是太垃圾了了）

```xml
<!--构造注入方式二：-->
    <bean id="car2" class="com.xuzhi.pojo.Car">
        <constructor-arg index="0" value="宝马" />
        <constructor-arg index="1" value="123123" />
    </bean>
```

```java
public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Car(double price, double speed) {
        this.price = price;
        this.speed = speed;
    }

    public Car(String name, double price, double speed) {
        this.name = name;
        this.price = price;
        this.speed = speed;
    }
```

注：他优先时候后面的构造器

**构造注入方式三：**（不推荐使用，感觉还是很垃圾的）

###根据构造方法里面的参数的类型注入

```xml
<!--构造方法注入三：-->
    <bean id="car3" class="com.xuzhi.pojo.Car" >
        <constructor-arg type="java.lang.String" value="宝马" />
        <constructor-arg type="java.lang.Double" value="123" />
    </bean>
```

#### Spring中各种值的注入

数组、List、Set、Map

如果其对应的值是简单的字面值，就直接写就可以了，如果是一个其他的类，那么使用内部bean的方式完成

```xml
<bean class="com.xuzhi.pojo.People" id="people" >
        <property name="name" value="小明" />
        <property name="age" value="12" />
        <property name="friends">
            <array>
                <value>小红</value>
                <value>小刚</value>
                <value>你爸爸</value>
            </array>
        </property>
        <property name="numbers">
            <list>
                <value>1</value>
                <value>2</value>
                <value>3</value>
            </list>
        </property>
        <property name="girls">
            <list>
                <!--内部bean，不能被外部所引用-->
                <bean class="com.xuzhi.pojo.Girl">
                    <property name="name" value="nihao" />
                </bean>
                <bean class="com.xuzhi.pojo.Girl">
                    <property name="name" value="测试" />
                </bean>
            </list>
        </property>
        <property name="pays">
            <set>
                <bean class="com.xuzhi.spring.AliPay">

                </bean>
                <bean class="com.xuzhi.spring.AliPay">

                </bean>
            </set>
        </property>
        <property name="girlMap">
           	<!--entry标签时map的键名，里面的内容是值-->
            <map>
                <entry key="girl1">
                <bean class="com.xuzhi.pojo.Girl">
                    <property name="name" value="nihaoi" />
                </bean>
                </entry>
                <entry key="girl2">
                    <bean class="com.xuzhi.pojo.Girl">
                        <property name="name" value="nihaoi" />
                    </bean>
                </entry>
            </map>
        </property>
    </bean>
```

#### 自动注入

###最新的官方文档推荐是用自动注入

- byType:按照数据类型注入
- byName：按照bean对应的pojo里面的属性的名字来进行匹配
- constructor
  - 有限按照类型去匹配，如果匹配到一个那么直接注入，不止一个按照名字注入，如果一个都找不到，注入失败
  - 
- default
- none

```xml
<!--byType注入-->
    <!--<bean class="com.xuzhi.pojo.Girl" id="girl" autowire="byType">-->
        <!--<property name="name" value="Girl1" />-->
        <!--<property name="age" value="12" />-->
    <!--</bean>-->
    <!--
        primary默认值为true
        如果有多个bean，并且它会按类型注入给其他bean，那么只能有一个primary为true
    -->
    <!--<bean  class="com.xuzhi.spring.AliPay" primary="true" >-->
    <!--</bean>-->
    <!--<bean class="com.xuzhi.spring.WXPay" primary="false" >-->
    <!--</bean>-->
    
    <!--byName注入-->
    <!--<bean class="com.xuzhi.pojo.Girl" id="girl" autowire="byName">-->
    <!--</bean>-->
    <!--<bean class="com.xuzhi.spring.AliPay" name="pay">-->
    <!--</bean>-->

    <!--constructor注入-->
    <!--<bean class="com.xuzhi.pojo.Girl" id="girl" autowire="constructor">-->
        <!--<constructor-arg name="name" value="nihao" />-->
    <!--</bean>-->
    <!--<bean class="com.xuzhi.spring.AliPay" name="pay">-->
    <!--</bean>-->
```

[^注]: byType是根据类型注入他的属性，此时在上下文当中搜寻Pay这种bean，找到有且仅有一个的情况下，将会注入成功，如果一个都没有，则不注入，如果不只一个，将会有异常		

#### 配置文件处理

```xml
<!--
        该配置文件为spring的整体配置文件，所有的spring操作只需要引用这一个配置文件即可
        因为在该配置文件中引用了其他的配置文件
        其他的每一个配置文件都分别对应了各自的要求
        例如：spring-mybatis.xml=>说明spring和mybatis整合是所需要的配置文件
    -->
    <!--这个标签可以将其他的配置文件引入，这样的话，我们将来整体读取这一个文件即可-->
    <!--分别导入配置文件-->
    <import resource="classpath:spring/spring-test.xml" />
    <import resource="classpath:spring/spring-test2.xml" />

    <!--可以导入spring文件夹下所有以spring-开头的配置文件-->
    <import resource="classpath:spring/spring-*.xml" />
```

```xml
<!--通过这种方式引入我们类路径下的文件-->
    <context:property-placeholder location="classpath:jdbc.properties" />
    <bean class="com.xuzhi.pojo.DaoTest" id="jdbc" >
        <!--
            ${}表达式可以可以去引用我们引入的这些properties里面的属性的值，通过他的键名得到值
        -->
        <property name="url" value="${url}" />
        <property name="driver" value="${driver}" />
        <property name="username" value="${username}" />
        <property name="password" value="${password}" />
    </bean>
```

注：使用import等标签时需要完整的xml命名空间

#### Spring常用注释

- Component
- Controller =>(SpringMVC)
- Service=>（业务层）
- Respository=>(dao层)

#### spring AOP

##### 额外补充依赖

```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.9.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.2</version>
</dependency>
```

##### 配置文件

```xml
<!--1、AOP是基于代理完成的，所以要激活我们的自动代理-->
<aop:aspectj-autoproxy />
<!--2、注册一个切面要使用的类-->
<bean class="com.xuzhi.advice.BeforeAdvice" id="beforeAdvice" >
</bean>
<!--3、配置切入点等信息-->
<aop:config>
    <aop:aspect id="beforeAspect" ref="beforeAdvice">
        <!--aop:before 表明他确实是前置通知
                method：指明他是使用哪个具体的方法来切
                pointcut:切入点
                        要切什么包下面的什么类下面的什么方法
            -->
        <!--如果有多个相同类型的建议，谁再前谁先执行-->
        <aop:before method="methodBefore" pointcut="execution(* com.xuzhi.service.ProviderService.add(..))" />
        <aop:before method="before" pointcut="execution(* com.xuzhi.service.ProviderService.add(..))" />
    </aop:aspect>
    <aop:aspect id="afterAspect" ref="afterAdvice">
        <!--
                execution(* com.xuzhi.service.ProviderService.add(..)) 切带有任意参数或者不带参数的add（）方法
                execution(* com.xuzhi.service.ProviderService.add()) 切无参数的方法
                execution(* com.xuzhi.service.ProviderService.add(String))  切只有一个String类型参数的方法
                execution(* com.xuzhi.service.ProviderService.add(String,int)) 切同时含有String和int类型的方法
            -->
        <aop:after method="methodAfter" pointcut="execution(* com.xuzhi.service.ProviderService.add(String,int))" />
    </aop:aspect>
</aop:config>
```

```java
//JoinPoint可以获取几乎所有的这个方法的信息
//作用，可以打印输出日志文件
public void before(JoinPoint joinPoint){
    //获取方法的方法名
    String name=joinPoint.getSignature().getName();
    System.out.println("method:"+name);
    //获取方法的参数
    Object[] args = joinPoint.getArgs();
    System.out.println(Arrays.toString(args));
}
```

#### AOP注解版

* Configuration:表明一个类为配置类，程序启动的时候只要扫描这个类，就可以清楚所有的配置规则
* Component：表明一个类为spring的一个组件，可以被spring容器所管理，他是一个普通组件的语义
* Service：同上，语义上属于服务层
* Repository：同上，语义上属于DAO层
* Controller：同上，语义上属于控制层
* ComponentScan：组件扫描，可以决定去扫描那些包
* Bean：用于在spring容器当中注册一个bean
* Autowired：自动注入组件

#### execution表达式

先写访问修饰符，包名的限定，类名，方法名，参数列表+组合条件符合，多个条件很都可以

```xml
<!--
	访问修饰符为public的并且是sz这个包或者包下面的任意的类的任意的方法的参数为一个，并且类型为String的方法，就可以切到
-->
public com.sz..*.*(String)

public com.sz.*.*.*(Integer )

```

### SpringMVC

#### 使用步骤：

1、创建web项目

2、编写web.xml，在其中注册一个特殊的servlet，前端控制器

3、编写一个springmvc的配置文件

​	1、注册一个视图解析器

4、编写控制器

5、编写一个结果页面



web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">

    <!--注册一个前端控制器
    -->
    <servlet>
        <!--如果我们不去修改spring配置文件默认的位置，那么springmvc会去web-inf路径下的springmvc-servlet.xml文件-->
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    </servlet>
    <!--servlet映射配置-->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <!--统一写“/”-->
        <url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>
```

依赖引入：

```xml
<!--添加servlet依赖-->
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
<!--添加springmvc的依赖-->
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.0.8.RELEASE</version>
</dependency>
```

##### 方法一:（貌似是不推荐使用，不太确定）

springmvc-servlet.xml

###springmvc的配置文件，对每一个springmvc控制器都需要配置bean标签

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--配置一个视图解析器
        常用内部资源视图解析器
    -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
        <!--1、前缀-->
        <property name="prefix" value="/jsp/" />
        <!--2、后缀-->
        <property name="suffix" value=".jsp" />
    </bean>
    <bean class="com.xuzhi.controller.HelloController" name="/helloController" >

    </bean>
</beans>
```

HelloController.java

###控制器，类似于struts的action

```java
package com.xuzhi.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现一个Controller接口的方式
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("hello","Hello World!");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}

```

hello.jsp

###视图代码

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
	Happy New Year:${hello}
</body>
</html>

```

#### SpringMVC分析

##### 组件分析

web.xml

注册前端控制器，目的在于，我们希望让springmvc去处理所有的请求

通过

```xml
<!--servlet映射配置-->
<servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <!--统一写“/”-->
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

确实是处理所有的请求（不是真的所有）

url-pattern的写法问题

- /  =>（推荐使用）

  - 处理所有的请求，但是和/*不一样，他处理完之后要出去的时候不会再去将这个hello.jsp当做一个新的请求，而是将这个渲染的结构直接返回给浏览器

- /*     =>（永远都不要这么写）

  - 不能写的原因：请求/helloController过去的时候，他的视图名称是hello，hello.jsp页面，他将其当做了一个叫hello.jsp的请求，尝试去匹配对应的Controller，但是我的容器当中根本不存在这样的controller，所以无法匹配，导致404

- *.do   

  - 这种方式，有的开发团队习惯将请求的行为加个小尾巴用以区分，*.do，*.action

  ​    

##### 关于前端控制器的解释

springmvc设计的理念是希望开发者尽量远离原生的servletAPI，API不是很好用，有些繁琐，将操作进一步的简化，他将很多东西责任进行了拆分，不希望我们将一些技术点绑定死，可以做到随意的切换。本身还是基于servlet设计的，分发的servlet，

##### springmvc配置文件名字的问题

默认情况下是dispatcherServlet的名字当做命名空间

[ServletName]-servlet.xml      (WEB-INF）

servletName-servlet.xml = namespace.xml

之下寻找

降配置文件移动位置之后，出现了相应的错误

如果非要重新使用另外一个名字，可以使用<init-param>

```xml
<!--可以使用init-param标签重新修改命名空间,
            在web-inf文件里可以使用mvc.xml文件，
            而不必一定使用springmvc-servlet.xml文件
         -->
<init-param>
    <param-name>namespace</param-name>
    <param-value>mvc</param-value>
</init-param>
```

默认的规则要求在web-inf下，但是maven项目的标准应该在resources下面，解决方案：

重新指定上下文的配置文件的位置即可

```xml
<init-param>
    <!--上下文配置的位置的指定
		此时是在类路径下寻找springmvc-servlet.xml的配置文件
                配置文件的名称可以根据自己的要求命名
            -->
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:springmvc-servlet.xml</param-value>
</init-param>
```

#### 视图解析器

springmvc支持多种视图技术

- jsp
- freemaker

内部的资源视图解析器

- 视图前缀
  - /jsp/他是我们的请求相应的资源的路径的配置， viewName：hello    /jsp/hello
- 视图后缀
  - .jsp 此时我们的前缀+视图名称+后缀 =/jsp/hello.jsp

解析器的作用类似于

```xml
request.getDispatcherServlet.forward(request,response);
```

物理视图是由逻辑视图转换而来

物理视图是webapp/jsp/hello.jsp

逻辑视图      **p View =prefix + logicViewName + suffix**

- prefix => 前缀
- logicViewName =>视图名称（在Controller中的ModelAndView的setViewName(）方法来指定）
- suffix =>后缀

控制器

是一种比较传统的实现一个接口的方式完成的，Controller

如果一个接口只有一个方法，这种接口叫做函数式接口

###ModelAndView方法是Controller接口内的唯一的一个方法，故Controller为函数式接口

```java
@Override
public ModelAndView handleRequest(HttpServletRequest httpServletRequest, 									HttpServletResponse httpServletResponse) throws Exception {
   
}
```

该代码类似于servlet里面由doGet doPost里面入参就是请求与相应。

在springmvc中，在model当中填充数据，然后在具体的视图进行展示

还需要在配置文件当中配置一下bean，这个bean要取个名字，就用来充当这个URI，他就处理一个请求，跟servlet的差别不是很大。

#### 注解开发模式(方法二：推荐使用)

基于实现接口的方式已经是过去式了，采用注解开发很简单

##### 基本注解

- @Controller

- @RequestMapping

  - 可以写在方法上
  - 也可以写在类上

  ###推荐使用二者结合的方式

  **组合使用实例**

  ```java
  @Controller
  @RequestMapping("/bye")
  public class ByeController {
      //要想访问该Controller具体的地址应该是":8080/bye/bye"
      @RequestMapping("/bye")
      public String bye(Model model){
          model.addAttribute("hello","我的世界");
          //返回的为viewName,即视图的名字,此时寻找视图的路径为 /jsp/hello.jsp
          return "hello";
      }
  }
  ```

  ###使用联合方式，第一个/bye可以区分大类，第二个/bye直接调用该具体Controller

##### springmvc-servlet.xml

###需要添加相应的命名空间，以使用Context

```xml
<!--配置一个注解扫描的包-->
<context:component-scan base-package="com.xuzhi.controller" />
<!--配置一个视图解析器
        常用内部资源视图解析器
    -->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
    <!--1、前缀-->
    <property name="prefix" value="/jsp/" />
    <!--2、后缀-->
    <property name="suffix" value=".jsp" />
</bean>
```

##### Controller.java

```java
package com.xuzhi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//使用注解需要在springmvc的配置文件里面导入一个包，以启动注解扫描
//不需要继承任何的类也不需要实现任何的接口
@Controller
public class ByeController {
    @RequestMapping
    public String bye(Model model){
        //往view层传值
        model.addAttribute("hello","我的世界");
        //返回的为viewName,即视图的名字,此时寻找视图的路径为 /jsp/hello.jsp
        return "hello";
    }
}
```

##### 注解开发步骤总结：

1、配置基础扫描的包，这样配置的注解才会生效

2、在指定的类上面添加@Controller注解

3、在Controller类的方法前添加@RequestMapping注解，类似于前面的Controller的那个名字（不同requesthandler处理的handlerMapping）



当我们写上Controller之后，就标记了它为spring的一个组件，并且是控制器的组件，此时我们的handlermapping会去扫描寻找这个controller是否与之匹配，如果发现匹配就把这里处理的工作交给它

匹配的规则：

具体的匹配就是通过请求的路径进行匹配的

@RequestMapping(URI)

此时就是通过这个URI进行匹配











