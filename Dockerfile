# 使用適當的基礎映像
FROM openjdk:17-jdk-slim

# 設置工作目錄
WORKDIR /app

# 安裝 Maven
RUN apt-get update && apt-get install -y maven

# 複製 Maven 配置文件
COPY pom.xml /app/pom.xml

# 下載 Maven 依賴
RUN mvn dependency:go-offline

# 複製源碼
COPY src /app/src

# 暴露應用程序端口
EXPOSE 8080

# 設置啟動命令
CMD ["mvn", "spring-boot:run"]
