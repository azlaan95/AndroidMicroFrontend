package com.azl.microfrontend.feature.dashboard;

import com.azl.microfrontend.core.database.dao.UserSessionDao;
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
public final class AccountViewModel_Factory implements Factory<AccountViewModel> {
  private final Provider<UserSessionDao> userSessionDaoProvider;

  public AccountViewModel_Factory(Provider<UserSessionDao> userSessionDaoProvider) {
    this.userSessionDaoProvider = userSessionDaoProvider;
  }

  @Override
  public AccountViewModel get() {
    return newInstance(userSessionDaoProvider.get());
  }

  public static AccountViewModel_Factory create(Provider<UserSessionDao> userSessionDaoProvider) {
    return new AccountViewModel_Factory(userSessionDaoProvider);
  }

  public static AccountViewModel newInstance(UserSessionDao userSessionDao) {
    return new AccountViewModel(userSessionDao);
  }
}
