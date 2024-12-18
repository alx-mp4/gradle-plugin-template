# Gradle Plugin Template
A gradle template to use as a base for Minecraft b1.7.3 plugin development, including utility classes for common plugin tasks and convenience.

## Usage
While the project may be compatible with other Integrated Development Environments (IDEs), it is highly recommended to use IntelliJ IDEA by JetBrains for optimal performance.

### How To Clone
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

### Notice
After cloning, update the `src/main/resources/plugin.yml` with your specific details.

## Prerequisites
- **JDK 8 Required**: This project is built upon JDK 8. Ensure that your development environment is set up with JDK 8 or a compatible version.

## Features
### Convenience
- **[build.gradle](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/build.gradle)**:
    - Names the plugin's compiled `.jar` file using the plugin's name and version directly from the `plugin.yml` file.
- **[Plugin](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/Plugin.java)**:
    - Includes the `onEnable` and `onDisable` methods for the plugin's functionality.
    - Loggers that utilize the plugin's name and version for when the plugin is enabled and disabled.

### Utility Classes
- **[AboutUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/AboutUtil.java)**:
    - **Purpose**: Provides methods to easily access information about the plugin, such as its name, version, authors, and description.
    - **Usage**: Use this utility to display plugin information in console logs, help commands, or any other context where plugin details are required.
    - **Features**:
        - Fetches plugin metadata from the `plugin.yml` file.
        - Returns formatted strings for logging or display.

- **[AccessUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/AccessUtil.java)**:
    - **Purpose**: Provides utility methods to interact with permissions, commands, and other access control aspects in the plugin.
    - **Usage**: Helps manage permissions, check user permissions, and handle command execution in a standardized way.
    - **Features**:
        - Permission checking.
        - Command execution.
        - Access control.

- **[ColorUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/ColorUtil.java)**:
    - **Purpose**: Formats text messages with color codes compatible with Minecraft.
    - **Usage**: Style text messages for players or logs using color codes.
    - **Features**:
        - Applies color and formatting codes.
        - Easy integration with Minecraft text formatting.

- **[ConfigUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/ConfigUtil.java)**:
    - **Purpose**: Handles configuration file reading and writing.
    - **Usage**: Use to manage plugin configuration files, loading configuration data at startup and saving changes at shutdown.
    - **Features**:
        - Reads configuration data from YAML files.
        - Writes changes back to YAML files.
        - Provides default values for configuration settings.

- **[DiscordUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/DiscordUtil.java)**:
    - **Purpose**: Facilitates interaction with Discord services.
    - **Usage**: Helps send messages to Discord channels or get information from Discord.
    - **Features**:
        - Sends messages to Discord channels.
        - Retrieves messages or information from Discord.
        - Supports both text and rich media messages.

- **[LoggerUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/LoggerUtil.java)**:
    - **Purpose**: Provides a unified logging utility for the plugin.
    - **Usage**: Standardizes logging across the plugin, using the plugin's name and version.
    - **Features**:
        - Logs messages with the plugin’s name and version.
        - Supports various log levels (INFO, WARN, SEVERE, etc.)
        - Integrates with both console and file logging.

- **[UpdateUtil](https://github.com/AleksandarHaralanov/Gradle-Plugin-Template/blob/master/src/main/java/org/example/plugin/util/UpdateUtil.java)**:
    - **Purpose**: Manages plugin updates.
    - **Usage**: Monitors and checks for updates, notifying owners in console if a new version is available.
    - **Features**:
        - Checks for new plugin versions.
        - Notifies owners of available updates.
        - Integrates with GitHub API for repositories.
