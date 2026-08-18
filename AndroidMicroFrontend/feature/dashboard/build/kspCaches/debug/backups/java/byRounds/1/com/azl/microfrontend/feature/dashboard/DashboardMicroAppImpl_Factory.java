package com.azl.microfrontend.feature.dashboard;

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
public final class DashboardMicroAppImpl_Factory implements Factory<DashboardMicroAppImpl> {
  @Override
  public DashboardMicroAppImpl get() {
    return newInstance();
  }

  public static DashboardMicroAppImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DashboardMicroAppImpl newInstance() {
    return new DashboardMicroAppImpl();
  }

  private static final class InstanceHolder {
    private static final DashboardMicroAppImpl_Factory INSTANCE = new DashboardMicroAppImpl_Factory();
  }
}
