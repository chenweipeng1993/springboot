# springboot
笔记
https://blog.csdn.net/Peng_Hong_fu/article/details/53691705
三种启动方式
第一种在项目的@SpringBootApplication注解的类上右击执行
第二种在项目的目录下有pom.xml的路径下执行mvn install
然后在执行java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar
启动
两种环境，测试和生产的不同的启动方式-两套配置
生产
java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
测试
java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

//这个方法相当于@Controller和@ResponseBody 返回json
@RestController
@PathVariable 获取url中的数据
@RequestParam 获取请求参数的值
@GetMapping 组合注解
@RequestMapping(value = {"/hello","hi"},method = RequestMethod.GET)
//@GetMapping(value = "/hello") 简写

//http://localhost:8084/springbootdemo/restHello/12?name=haha
@GetMapping(value = "/restHello/{id}")
public String restHello(@PathVariable(value = "id") Integer id, @PathParam("name") String name){
	return "id:"+id+",name:"+name;
}

springboot web
----
下载代码
git clone git@git.8*****
切换不同版本的代码-创建本地分支和服务端tag一样的名字
git checkout -b web-2 web-2

//打包，跳过单元测试
mvn clean package -Dmaven.test.skip=true