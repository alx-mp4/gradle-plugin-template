# Gradle Plugin Template
A gradle template to use as a base for Minecraft b1.7.3 plugin development, including utility classes for common plugin tasks and convenience.

---
## Features
### Convenience
- **[build.gradle](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/build.gradle)**:
    - Names the plugin's compiled `.jar` file using the plugin's name and version directly from the `plugin.yml` configuration.
- **[Plugin](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/Plugin.java)**:
    - Includes the `onEnable` and `onDisable` methods for the plugin's functionality.
    - Loggers that utilize the plugin's name and version for when the plugin is enabled and disabled.

### Utility Classes
- **[AboutUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/AboutUtil.java)**:
    - **Purpose**: Provides methods to easily access information about the plugin, such as its name, version, authors, contributors, and description.
    - **Usage**: Use this utility to display plugin information in console logs, help commands, or any other context where plugin details are required.

- **[AccessUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/AccessUtil.java)**:
    - **Purpose**: Provides utility methods to interact with permissions, commands, and other access control aspects in the plugin.
    - **Usage**: Helps manage permissions, check user permissions, and handle command execution in a standardized way.

- **[ColorUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/ColorUtil.java)**:
    - **Purpose**: Formats text messages with color codes compatible with Minecraft.
    - **Usage**: Style text messages for players or logs using color codes.

- **[ConfigUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/ConfigUtil.java)**:
    - **Purpose**: Handles configuration file reading and writing.
    - **Usage**: Use to manage plugin configuration files, loading configuration data at startup and saving changes at shutdown.

- **[DiscordUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/DiscordUtil.java)**:
    - **Purpose**: Facilitates interaction with Discord services.
    - **Usage**: Helps send messages to Discord channels or get information from Discord.

- **[LoggerUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/LoggerUtil.java)**:
    - **Purpose**: Provides a unified logging utility for the plugin.
    - **Usage**: Standardizes logging across the plugin, using the plugin's name and version.

- **[UpdateUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/UpdateUtil.java)**:
    - **Purpose**: Manages plugin updates.
    - **Usage**: Monitors and checks for updates, notifying owners in console if a new version is available.

---
## Contributing Code & Reporting Issues
Consider helping this template become even more versatile and robust.

Visit the [CONTRIBUTING](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/.github/CONTRIBUTING.md) guide for details on how to get started and where to focus your efforts.

For any issues with the template, or suggestions, please report them [here](https://github.com/AleksandarHaralanov/gradle-plugin-template/issues).

---
## How To Clone
1. **Via VCS**:
    - Open IntelliJ IDEA.
    - Go to `File > New > Project from Version Control`.
    - If you're on the dashboard home screen of the IDE, click `CLONE FROM VCS` on the top-right button.
    - In the `URL` field, paste the repository link:
      ```
      https://github.com/AleksandarHaralanov/gradle-plugin-template
      ```
    - Rename your project to have your desired plugin name.
    - Click `Clone` to download the project.

2. **Via Git**:
    - Open your terminal and run the following command:
      ```bash
      git clone https://github.com/AleksandarHaralanov/gradle-plugin-template.git <project-name>
      ```

---
## Usage
While the project may be compatible with other Integrated Development Environments (IDEs), it is highly recommended to use IntelliJ IDEA by JetBrains for optimal performance.

**JDK 8 Required**: This project is built upon JDK 8. Ensure that your development environment is set up with JDK 8 or a compatible version.

> [!NOTE]
> 1. Update `src/main/resources/plugin.yml` with your plugin details.
> 2. Update `settings.gradle` with your plugin name.
> 3. Update/Remove `.github/FUNDING.yml`.