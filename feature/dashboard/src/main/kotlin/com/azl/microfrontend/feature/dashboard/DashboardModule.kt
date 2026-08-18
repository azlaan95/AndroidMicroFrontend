package com.azl.microfrontend.feature.dashboard

import com.azl.microfrontend.core.navigation.MicroApp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class DashboardModule {
    @Binds
    @IntoSet
    abstract fun bindDashboardMicroApp(impl: DashboardMicroAppImpl): MicroApp
}
