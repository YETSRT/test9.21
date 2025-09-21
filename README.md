# SpringBoot Security Demo

这是一个使用 SpringBoot 3.2.0 和 SpringSecurity 的演示项目。

## 功能特性

- SpringBoot 3.2.0
- SpringSecurity 认证
- 需要认证的 HelloWorld API
- 用户名密码登录 API

## API 接口

### 1. HelloWorld API
- **URL**: `GET /api/hello`
- **认证**: 需要 Basic 认证
- **响应**: "Hello World"

### 2. 登录 API
- **URL**: `POST /api/login`
- **认证**: 无需认证
- **请求体**:
```json
{
  "username": "test",
  "password": "123456"
}
```
- **响应**:
```json
{
  "success": true,
  "message": "登录成功",
  "username": "test"
}
```

## 默认用户

- **用户名**: test
- **密码**: 123456

## 运行方式

1. 确保已安装 Java 17 或更高版本
2. 确保已安装 Maven 3.6 或更高版本
3. 在项目根目录执行：
```bash
mvn spring-boot:run
```

## 测试 API

### 测试 HelloWorld API（需要认证）
```bash
curl -u test:123456 http://localhost:8080/api/hello
```

### 测试登录 API
```bash
curl -X POST http://localhost:8080/api/login \
  -H "Content-Type: application/json" \
  -d '{"username":"test","password":"123456"}'
```

## 项目结构

```
src/
├── main/
│   ├── java/
│   │   └── com/example/springbootsecuritydemo/
│   │       ├── SpringBootSecurityDemoApplication.java
│   │       ├── config/
│   │       │   └── SecurityConfig.java
│   │       └── controller/
│   │           ├── AuthController.java
│   │           └── HelloController.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
        └── com/example/springbootsecuritydemo/
            └── SpringBootSecurityDemoApplicationTests.java
```

## 技术栈

- Java 17
- SpringBoot 3.2.0
- SpringSecurity 6.x
- Maven 3.6+
