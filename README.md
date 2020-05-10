# JceKt
JCE protocol support for kotlinx.serialization

### What is JCE?
See https://blog.csdn.net/jiange_zh/article/details/86562232

### Dependencies
- [kotlinx-io](https://github.com/kotlin/kotlinx-io)
- [kotlinx.serialization](https://github.com/kotlin/kotlinx.serialization)

### Quick start

Latest stable version is `1.0.0`.

This library is multiplatform, supporting JVM and JS.

#### Gradle
Replace `<version>` with the newest version here: [![Download](https://api.bintray.com/packages/him188moe/jcekt/jcekt/images/download.svg)](https://bintray.com/him188moe/jcekt/jcekt/)

```kotlin
repositories {
  jcenter()
}
```

```kotlin
dependencies {
  // choose one of them depending on your platform
  implementation("moe.him188:jcekt:<version>") // JVM
  implementation("moe.him188:jcekt-common:<version>") // common
  implementation("moe.him188:jcekt-js:<version>") // JS
}
```


#### Maven
Replace `$version` with the newest version here: [![Download](https://api.bintray.com/packages/him188moe/jcekt/jcekt/images/download.svg)](https://bintray.com/him188moe/jcekt/jcekt/)

```xml
<repository>
    <name>jcenter</name>
    <url>https://jcenter.bintray.com/</url>
</repository>
```
```xml
<dependency>
    <groupId>moe.him188</groupId>
    <artifactId>jcekt</artifactId>
    <version>$version</version>
</dependency>
```



```kotlin
@Serializable
data class Account(
    @JceId(0) val id: Int, 
    @JceId(1) val name: String = "", // having default value means optional
    @JceId(2) val age: Short = 20,
    @JceId(6) val friends: List<Account> = listOf() // nesting supported
    // @JceId must exist on every field
)

val bytes = Jce.UTF_8.dump(Account.serializer(), Account(1, "Alice", 20, listOf(Account(2, "Bob", 22))))
val account = Jce.UTF_8.load(Account.serializer(), bytes)
```

This is the full usage of this library.
