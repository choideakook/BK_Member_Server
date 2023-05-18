<div align="center"><h1>🤚🏻BAEKER 의 Member Server 입니다.</h1></div>
<div align="center"><a href="https://github.com/PARKPARKWOO/Baeker-MSA"><b>🔗 View Server Repository</b></a></div>
<div align="center"><a href="https://github.com/choideakook/CloudConfig"><b>🔗 Spring Cloud Config Repository</b></a></div>

<br>

## End point
### 조회
- find by username : /api/member/get/v1/username
```
String username
```
- find by id : /api/member/get/v1/id

```java
Long id
```

- find by all for scheduler : /api/member/get/v1/all
```java
none
```
- find by all + page : /api/member/get/v1/pageAll
```java
    private int page;
    private String standard;
    private int maxContent;
    private boolean asc;
```

<br>

## 수정
- create : /api/member/v1/create
```java
    private String username;
    private String nickName;
    private String password;
    private String provider;
    private String email;
    private String token;
    private String profileImage;
```
- update : /api/member/v1/update
```java
    private Long id;
    private String nickname;
    private String about;
    private String profileImg;
```
- connect 백준 : /api/member/v1/connect
```java
    @NotNull
    private Long id;
    @NotNull
    private String baekJoonName;
```
