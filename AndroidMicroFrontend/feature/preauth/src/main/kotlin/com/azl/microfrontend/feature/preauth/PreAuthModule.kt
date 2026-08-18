package com.azl.microfrontend.feature.preauth

import com.azl.microfrontend.core.navigation.MicroApp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class PreAuthModule {
    @Binds
    @IntoSet
    abstract fun bindPreAuthMicroApp(impl: PreAuthMicroAppImpl): MicroApp
}
