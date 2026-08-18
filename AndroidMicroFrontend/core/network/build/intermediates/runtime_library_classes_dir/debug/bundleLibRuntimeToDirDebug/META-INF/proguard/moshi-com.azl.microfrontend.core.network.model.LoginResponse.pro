-if class com.azl.microfrontend.core.network.model.LoginResponse
-keepnames class com.azl.microfrontend.core.network.model.LoginResponse
-if class com.azl.microfrontend.core.network.model.LoginResponse
-keep class com.azl.microfrontend.core.network.model.LoginResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
