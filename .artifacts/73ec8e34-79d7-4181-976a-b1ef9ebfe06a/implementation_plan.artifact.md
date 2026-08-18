# Modular Micro Frontend (MFE) Android App Scaffolding

This plan outlines the steps to scaffold a multi-module Android application using Jetpack Compose, Hilt, and Clean Architecture principles.

## Proposed Changes

### Core Infrastructure
- **[MODIFY] [libs.versions.toml](file:///D:/Workspace/Android/InterviewPreparation/gradle/libs.versions.toml)**: Add all required dependencies and plugins.
- **[MODIFY] [settings.gradle.kts](file:///D:/Workspace/Android/InterviewPreparation/settings.gradle.kts)**: Include all new core and feature modules.
- **[MODIFY] [build.gradle.kts](file:///D:/Workspace/Android/InterviewPreparation/build.gradle.kts)**: Add Hilt and KSP plugins.

### Core Modules
- **[NEW] core:common**: Base abstractions (Result, MVI/MVVM bases, Dispatchers).
- **[NEW] core:network**: Retrofit, Moshi, Interceptors.
- **[NEW] core:database**: Room DB setup.
- **[NEW] core:datastore**: DataStore setup.
- **[NEW] core:designsystem**: Material3 theme and shared UI components.
- **[NEW] core:navigation**: Type-safe navigation contracts.

### Feature Modules (MicroApps)
- **[NEW] feature:preauth**
- **[NEW] feature:onboarding**
- **[NEW] feature:dashboard**
- **[NEW] feature:profile**

### App Module
- **[MODIFY] app**: Configure Hilt Application, Root Activity, and Compose Navigation entry point.

## Verification Plan

### Automated Tests
- Run `gradlew assembleDebug` to ensure all modules build correctly.
- Verify Hilt dependency graph with a simple test.

### Manual Verification
- Deploy to device/emulator to see the splash or initial feature screen.
