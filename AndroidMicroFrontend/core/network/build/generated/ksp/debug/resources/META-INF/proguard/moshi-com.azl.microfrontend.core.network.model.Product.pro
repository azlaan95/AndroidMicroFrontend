-if class com.azl.microfrontend.core.network.model.Product
-keepnames class com.azl.microfrontend.core.network.model.Product
-if class com.azl.microfrontend.core.network.model.Product
-keep class com.azl.microfrontend.core.network.model.ProductJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
