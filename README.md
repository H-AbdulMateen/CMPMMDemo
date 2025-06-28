This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

# 🛒 Compose Shop App

A modern shopping app built using **Kotlin Multiplatform** (Android only for now) with **Jetpack Compose** UI, **Ktor** for networking, and **Koin** for dependency injection. This app demonstrates a modular architecture with clean separation of concerns and scalable design patterns.

> ⚠️ The app is still in development.

---

## 🚀 Features

- 🔐 Login screen with secure password visibility toggle
- 🛍️ Product listing with images, details, and price
- ❤️ Wishlist management
- 🛒 Cart support
- 👤 Profile screen with logout option
- 📦 Multi-module architecture
- 📸 Coil integration for image loading
- 📡 Ktor-powered API integration
- 🧭 Jetpack Compose Navigation
- 💉 Koin for DI

---

## 📸 Screenshots

| Login Screen | Home Screen | Profile Screen |
|--------------|-------------|----------------|
| ![Login](assets/screenshots/Screenshot_20250628_103918.png) | ![Home](assets/screenshots/Screenshot_20250628_104042.png) | ![Profile](assets/screenshots/Screenshot_20250628_104101.png) |

---

## 🧱 Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Architecture**: Multi-module
- **Networking**: Ktor
- **Dependency Injection**: Koin
- **Image Loading**: Coil
- **Navigation**: Compose Navigation

---

