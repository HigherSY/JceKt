# JceKt
JCE protocol support for kotlinx.serialization

## What is JCE?
See https://blog.csdn.net/jiange_zh/article/details/86562232

### Dependencies
- [kotlinx-io](https://github.com/kotlin/kotlinx-io)
- [kotlinx.serialization](https://github.com/kotlin/kotlinx.serialization)

### Quick start

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
