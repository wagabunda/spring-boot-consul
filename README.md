# Reproduce the problem with defaultContext in Spring Boot 2.4.2 

1. Run Consul (or use existing)
`docker-compose up -d`
   
1. Fill k/v store
    - in existing consul
   ```shell
   consul kv put "dev/defaults/user/foo" "value from the default context"
   consul kv put "dev/spring-boot-consul/user/foo" "value from the application contex"
   ```
    - in created by above command
   ```shell
   docker-compose exec consul consul kv put "dev/defaults/user/foo" "value from the default context"
   docker-compose exec consul consul kv put "dev/spring-boot-consul/user/foo" "value from the application context"
   ```

1. Run application
    1. `gradlew app-2-4:bootRun`
        ```shell
         :: Spring Boot ::                (v2.4.2)
        [...]
        [...] foo property value: 'value from the default context'
        ```
    1. `gradlew app-2-3:bootRun`
        ```shell
         :: Spring Boot ::        (v2.3.8.RELEASE)
        [...]
        [...] foo property value: 'value from the application context'
        ```       
        