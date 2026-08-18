package com.azl.microfrontend.feature.preauth;

import com.azl.microfrontend.core.common.DispatcherProvider;
import com.azl.microfrontend.core.database.dao.UserSessionDao;
import com.azl.microfrontend.core.network.AuthService;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<AuthService> authServiceProvider;

  private final Provider<UserSessionDao> userSessionDaoProvider;

  private final Provider<DispatcherProvider> dispatcherProvider;

  public LoginViewModel_Factory(Provider<AuthService> authServiceProvider,
      Provider<UserSessionDao> userSessionDaoProvider,
      Provider<DispatcherProvider> dispatcherProvider) {
    this.authServiceProvider = authServiceProvider;
    this.userSessionDaoProvider = userSessionDaoProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(authServiceProvider.get(), userSessionDaoProvider.get(), dispatcherProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<AuthService> authServiceProvider,
      Provider<UserSessionDao> userSessionDaoProvider,
      Provider<DispatcherProvider> dispatcherProvider) {
    return new LoginViewModel_Factory(authServiceProvider, userSessionDaoProvider, dispatcherProvider);
  }

  public static LoginViewModel newInstance(AuthService authService, UserSessionDao userSessionDao,
      DispatcherProvider dispatcherProvider) {
    return new LoginViewModel(authService, userSessionDao, dispatcherProvider);
  }
}
