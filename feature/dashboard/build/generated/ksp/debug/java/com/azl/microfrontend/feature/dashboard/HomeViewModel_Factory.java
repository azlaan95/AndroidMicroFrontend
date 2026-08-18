package com.azl.microfrontend.feature.dashboard;

import com.azl.microfrontend.core.common.DispatcherProvider;
import com.azl.microfrontend.core.network.ProductService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<ProductService> productServiceProvider;

  private final Provider<DispatcherProvider> dispatcherProvider;

  public HomeViewModel_Factory(Provider<ProductService> productServiceProvider,
      Provider<DispatcherProvider> dispatcherProvider) {
    this.productServiceProvider = productServiceProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(productServiceProvider.get(), dispatcherProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<ProductService> productServiceProvider,
      Provider<DispatcherProvider> dispatcherProvider) {
    return new HomeViewModel_Factory(productServiceProvider, dispatcherProvider);
  }

  public static HomeViewModel newInstance(ProductService productService,
      DispatcherProvider dispatcherProvider) {
    return new HomeViewModel(productService, dispatcherProvider);
  }
}
