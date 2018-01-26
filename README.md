## git-flow 

## Spring cloud 各模块简介
1. eureka-server：服务注册中心。端口为：`1111`
2. eureka-client：服务提供者。 服务名为：`hello-service`，启动端口为 `8081` 和 `8082`, 启动命令：`java -jar ` 
3. ribbon-consumer：服务消费者，做负载均衡，启动容断保护。端口：`9000`
4. hystrix-dashboard：容断监控，集成了 turbine。访问：localhost:2001/hystrix/
    - 对单个应用的监控：http://localhost:90000/hystrix.stream
    - 对集群应用的监控：http://localhost:2001/turbine.stream 或者 http://turbine-hostname:port/turbine.stream?cluster=[clusterName] 
5. feign-consumer：声明式服务。端口：9001
6. zuul-api-gateway：网关服务。端口：5555
7. config-server：分布式配置中心服务端，用来连接配置仓库并为客户端提供获取配置信息、加密/解密信息等访问接口。端口：7001
    - http://localhost:7001/config-label-test/cloud-dev.properties
    - http://localhost:7001/cloud-dev.properties
8. config-client：分布式配置中心客户端，管理应用资源与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息。端口：7002
    - http://localhost:7002/from