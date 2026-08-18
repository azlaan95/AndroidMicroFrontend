package com.azl.microfrontend.feature.preauth;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class PreAuthMicroAppImpl_Factory implements Factory<PreAuthMicroAppImpl> {
  @Override
  public PreAuthMicroAppImpl get() {
    return newInstance();
  }

  public static PreAuthMicroAppImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PreAuthMicroAppImpl newInstance() {
    return new PreAuthMicroAppImpl();
  }

  private static final class InstanceHolder {
    private static final PreAuthMicroAppImpl_Factory INSTANCE = new PreAuthMicroAppImpl_Factory();
  }
}
