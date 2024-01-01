# Compose Multiplatform Application

[Live Website](https://emami-114.github.io/portfolio/)

## Before running!

- check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
- install JDK 17 on your machine
- add `local.properties` file to the project root and set a path to Android SDK there

### Android

To run the application on android device/emulator:

- open project in Android Studio and run imported android run configuration

To build the application bundle:

- run `./gradlew :composeApp:assembleDebug`
- find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`

### Desktop

Run the desktop application: `./gradlew :composeApp:run`

### iOS

To run the application on iPhone device/simulator:

- Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
- Or
  use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)
  for Android Studio

### Browser

Run the browser application: `./gradlew :composeApp:jsBrowserDevelopmentRun`

## Android Images

![android-sim1.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fandroid-sim1.png)
![android-sim2.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fandroid-sim2.png)
![android-sim3.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fandroid-sim3.png)

## iOS Images

![iOS1.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2FiOS1.png)
![iOS2.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2FiOS2.png)
![iOS4.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2FiOS4.png)

## Desktop Images

![jvm1.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fjvm1.png)
![jvm2.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fjvm2.png)
![jvm3.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fjvm3.png)

## Web Images
![web1.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fweb1.png)
![web2.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fweb2.png)
![web3.png](composeApp%2Fsrc%2FcommonMain%2Fresources%2Fweb3.png)
