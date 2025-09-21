
# SpringBoot Security Demo

这是一个使用 SpringBoot 3.2.0 和 SpringSecurity 的演示项目。

## 功能特性

- SpringBoot 3.2.0
- SpringSecurity 认证
- JWT Token 认证
- 需要认证的 HelloWorld API
- 用户名密码登录 API

## API 接口

### 1. HelloWorld API
- **URL**: `GET /api/hello`
- **认证**: 需要 JWT Token 认证
- **请求头**: `Authorization: Bearer <JWT_TOKEN>`
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
  "username": "test",
  "token": "eyJhbGciOiJIUzI1NiJ9..."
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

### 1. 测试登录 API 获取 JWT Token
```bash
curl -X POST http://localhost:8080/api/login \
  -H "Content-Type: application/json" \
  -d '{"username":"test","password":"123456"}'
```

### 2. 测试 HelloWorld API（使用 JWT Token）
```bash
# 首先获取 JWT Token（从登录响应中复制 token 值）
TOKEN="eyJhbGciOiJIUzI1NiJ9..."

# 使用 JWT Token 访问受保护的 API
curl -H "Authorization: Bearer $TOKEN" http://localhost:8080/api/hello
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
│   │       ├── controller/
│   │       │   ├── AuthController.java
│   │       │   └── HelloController.java
│   │       ├── dto/
│   │       │   ├── LoginRequest.java
│   │       │   └── LoginResponse.java
│   │       ├── filter/
│   │       │   └── JwtAuthenticationFilter.java
│   │       ├── service/
│   │       │   └── AuthService.java
│   │       └── util/
│   │           └── JwtUtil.java
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
- JWT (JSON Web Token)
- Maven 3.6+

# test9.21
五维数据笔试题
e93b5989c22a90a1cc29a83b11cf2d69d98d8f5f
