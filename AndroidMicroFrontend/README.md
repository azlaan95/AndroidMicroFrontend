# Android Micro Frontend (MFE) Architecture

This project demonstrates a robust **Micro Frontend (MFE)** architecture for Android, leveraging a modular structure, Jetpack Compose, Hilt Multibindings, and Clean Architecture principles.

## 🏗 Architecture Overview

The application is built on the principle of **Loose Coupling** and **High Cohesion**, where features are developed as independent "MicroApps" that can be plugged into a central "App Shell".

### Core Components

*   **App Shell (`:app`)**: The orchestrator. It doesn't contain business logic. Its primary role is to initialize the DI graph, set up the `NavHost`, and dynamically register all available `MicroApps`.
*   **Core Modules (`:core:*`)**: Shared infrastructure and contracts.
    *   `:core:navigation`: Defines the `MicroApp` interface and shared route contracts.
    *   `:core:designsystem`: A unified Material3 theme and shared UI components (Atomic Design).
    *   `:core:common/network/database`: Shared data layers and utilities.
*   **MicroApps (`:feature:*`)**: Isolated feature modules.
    *   `:feature:preauth`, `:feature:onboarding`, `:feature:dashboard`, `:feature:profile`.
    *   Each module is independent and only depends on `:core` modules.

---

## 🧭 How it Works: Plug-and-Play Navigation

The MFE implementation uses **Hilt Multibindings** to achieve true inversion of control for feature registration.

1.  **The Contract**: `:core:navigation` defines the `MicroApp` interface.
    ```kotlin
    interface MicroApp {
        fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
    }
    ```
2.  **Registration**: Each feature module implements this interface and contributes it to a `Set<MicroApp>` via Hilt:
    ```kotlin
    @Module @InstallIn(SingletonComponent::class)
    abstract class FeatureModule {
        @Binds @IntoSet
        abstract fun bindMicroApp(impl: FeatureMicroAppImpl): MicroApp
    }
    ```
3.  **Discovery**: The `:app` module injects the entire set and iterates through it to build the navigation graph:
    ```kotlin
    @Inject lateinit var microApps: Set<MicroApp>
    // ...
    NavHost(...) {
        microApps.forEach { it.registerGraph(this, navController) }
    }
    ```

---

## 🛠 Tech Stack

*   **UI**: Jetpack Compose (Material 3)
*   **Dependency Injection**: Hilt (Standard & Multibindings)
*   **Navigation**: Jetpack Navigation Compose (Type-safe contracts)
*   **Concurrency**: Kotlin Coroutines & Flow
*   **Local Data**: Room & DataStore
*   **Network**: Retrofit & Moshi
*   **Build System**: Kotlin DSL (Gradle) with Version Catalog (`libs.versions.toml`)

---

## 📁 Project Structure

```text
├── app/                  # App Shell / Orchestrator
├── core/
│   ├── common/           # Result wrappers, Base ViewModels, Dispatchers
│   ├── database/         # Room persistence
│   ├── datastore/        # Key-Value storage
│   ├── designsystem/     # Theme, Typography, Atomic UI Components
│   ├── navigation/       # Routing contracts and MicroApp interface
│   └── network/          # Retrofit setup and API interceptors
└── feature/
    ├── dashboard/        # Dashboard MicroApp
    ├── onboarding/       # Onboarding MicroApp
    ├── preauth/          # Login/Signup MicroApp
    └── profile/          # User Profile MicroApp
```

---

## 🧪 Development Standards

The project follows strict guidelines defined in the `.gemini/` directory:
- **`navigation-router.agent.md`**: Rules for path-based routing and safe fallback.
- **`presentation-mfe.agent.md`**: Standards for Stateful/Stateless Compose components.
- **`core-infra-data.agent.md`**: Data layer abstractions and repository patterns.

## 🚀 Getting Started

1.  Clone the repository.
2.  Open in **Android Studio Ladybug** or newer.
3.  Sync Gradle and run the `:app` module.
