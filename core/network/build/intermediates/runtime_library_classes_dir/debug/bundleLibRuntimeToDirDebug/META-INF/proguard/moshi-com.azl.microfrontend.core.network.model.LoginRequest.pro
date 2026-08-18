-if class com.azl.microfrontend.core.network.model.LoginRequest
-keepnames class com.azl.microfrontend.core.network.model.LoginRequest
-if class com.azl.microfrontend.core.network.model.LoginRequest
-keep class com.azl.microfrontend.core.network.model.LoginRequestJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.azl.microfrontend.core.network.model.LoginRequest
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.azl.microfrontend.core.network.model.LoginRequest
-keepclassmembers class com.azl.microfrontend.core.network.model.LoginRequest {
    public synthetic <init>(java.lang.String,java.lang.String,java.lang.Integer,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
