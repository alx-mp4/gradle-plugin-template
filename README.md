# Gradle Plugin Template
A gradle template to use as a base for Minecraft b1.7.3 plugin development, including utility classes for common plugin tasks and convenience.

---
## Utility Classes
- **[AboutUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/1dfd192aef0cc06febd9a042807599241937cd85/src/main/java/org/example/plugin/util/AboutUtil.java)**:
    - Provides methods to display detailed information about a plugin—including its name, version, description, website, author(s), and contributor(s)—to a player or the server console.

- **[AccessUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/1dfd192aef0cc06febd9a042807599241937cd85/src/main/java/org/example/plugin/util/AccessUtil.java)**:
    - Provides methods to check permissions and enforce command usage restrictions based on the sender's type.

- **[ColorUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/1dfd192aef0cc06febd9a042807599241937cd85/src/main/java/org/example/plugin/util/ColorUtil.java)**:
    - Provides a method to scan text for color codes prefixed with an ampersand `&` and replace them with the appropriate Minecraft color code format using the section sign `§` symbol.

- **[ConfigUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/1dfd192aef0cc06febd9a042807599241937cd85/src/main/java/org/example/plugin/util/ConfigUtil.java)**:
    - Provides methods for loading, saving, and managing configuration files. It automatically handles the creation of parent directories and copies default configuration files from the plugin's resources if they do not exist.

- **[DiscordUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/1dfd192aef0cc06febd9a042807599241937cd85/src/main/java/org/example/plugin/util/DiscordUtil.java)**:
    - Provides methods for setting up a Discord webhook message with content, username, avatar, text-to-speech (TTS) options, and rich embed objects.

- **[LogUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/1dfd192aef0cc06febd9a042807599241937cd85/src/main/java/org/example/plugin/util/LogUtil.java)**:
    - Provides methods for logging info, warning, and severe messages through the server's logger into the console, simplifying the process of logging by avoiding the need to directly access the logger. Additionally, it allows to manage log files within the plugin's data folder where custom log messages can be written.

- **[UpdateUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/1dfd192aef0cc06febd9a042807599241937cd85/src/main/java/org/example/plugin/util/UpdateUtil.java)**:
    - Provides a method to query the GitHub API for the latest release version and compares it with the current plugin version. It logs messages to the console indicating whether an update is available or if the plugin is up to date.

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
### Setup Project
While the project may be compatible with other Integrated Development Environments (IDEs), it is highly recommended to use [IntelliJ IDEA by JetBrains](https://www.jetbrains.com/idea/) for optimal performance.

**JDK 1.8 Required:** This project is built upon JDK 1.8. Ensure that your development environment is set up with JDK 1.8.
1. Set Up the Gradle JVM:
    - Open **File > Settings > Build, Execution, Deployment > Build Tools > Gradle**.
    - In the **Gradle JVM** dropdown, select **Download JDK**. 
    - Choose **JDK 1.8** (Vendor: **Eclipse Temurin**) and use the default location. 
    - Ensure the newly downloaded JDK is selected, then click **Apply** and **OK**.
2. Configure the Project SDK:
   - Open **File > Project Structure**.
   - Under Project Settings, set the **SDK** to **1.8** and **Language Level** to **SDK default**.
   - Click **Apply** and **OK**.

> [!IMPORTANT]
> 1. Update package names `org.example.plugin` accordingly.
> 2. Update `src/main/resources/plugin.yml` with your plugin details.
> 3. Update `settings.gradle` with your plugin name.

### Build Project
Once you finish developing your plugin, follow these steps to build your project using Gradle:

1. **Open Gradle:** Click on the Gradle tab located in the right-side menu bar.
2. **Locate the Build Task:** Expand the `Tasks/build` section and double-click on the `build` task to start your first build process.
3. **Find Your Plugin's JAR:** After the build completes, a new `build` directory will appear in your project. Navigate to `build/libs` where you'll find your plugin's `.jar` file.
4. **Ready To Be Used:** You can now drag and drop your plugin into the `plugins` directory of your Minecraft b1.7.3 server.

> [!TIP]
> Always run the `clean` task from the build tasks before running the `build` task to ensure a fresh build.