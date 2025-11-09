<h1><a href="#"><img src="https://skillicons.dev/icons?i=gradle" alt="Gradle" style="width:22px;"></a> Minecraft b1.7.3 - Gradle Plugin Template</h1> 
A gradle template to use as a base for Minecraft b1.7.3 plugin development, including utility classes for common plugin tasks and convenience.

---
## Included Utility Classes
All included utility classes are accompanied by well-written javadocs.

- **[AboutUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/misc/AboutUtil.java)**:
    - Provides methods to display detailed information about a plugin—including its name, version, description, website, author(s), and contributor(s)—to a player or the server console.

- **[AccessUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/auth/AccessUtil.java)**:
    - Provides methods to check permissions and enforce command usage restrictions based on the sender's type.

- **[ColorUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/misc/ColorUtil.java)**:
    - Provides a method to scan text for color codes prefixed with an ampersand `&` and replace them with the appropriate Minecraft color code format using the section sign `§` symbol.

- **[ConfigUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/config/ConfigUtil.java)**:
    - Provides methods for loading, saving, and managing configuration files. It automatically handles the creation of parent directories and copies default configuration files from the plugin's resources if they do not exist.

- **[DiscordUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/log/DiscordUtil.java)**:
    - Provides methods for setting up a Discord webhook message with content, username, avatar, text-to-speech (TTS) options, and rich embed objects.

- **[EffectUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/misc/EffectUtil.java)**:
    - Provides a method for displaying block break (step sound) particle effects to a specific player. It encodes the block’s ID and data value into the format used by Minecraft Beta 1.7.3, enabling accurate visual effects for different block variants such as colored wool or wood types.

- **[LogUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/log/LogUtil.java)**:
    - Provides methods for logging info, warning, and severe messages through the server's logger into the console, simplifying the process of logging by avoiding the need to directly access the logger. Additionally, it allows to manage log files within the plugin's data folder where custom log messages can be written.

- **[UpdateUtil](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/src/main/java/org/example/plugin/util/log/UpdateUtil.java)**:
    - Provides a method to query the GitHub API for the latest release version and compares it with the current plugin version. It logs messages to the console indicating whether an update is available or if the plugin is up to date.

---
## Contributing Code & Reporting Issues
Consider helping this template become even more versatile and robust.

Visit the [CONTRIBUTING](https://github.com/AleksandarHaralanov/gradle-plugin-template/blob/master/.github/CONTRIBUTING.md) guide for details on how to get started and where to focus your efforts.

For any issues with the template, or suggestions, please report them [here](https://github.com/AleksandarHaralanov/gradle-plugin-template/issues).

---
## How To Clone
1. **Via VCS**:
    - Open **IntelliJ IDEA**.
    - Open **File > New > Project from Version Control**.
    - If you're on the dashboard home screen of the IDE, click **CLONE FROM VCS** on the top-right button.
    - In the **URL** field, paste the repository link:
      ```
      https://github.com/AleksandarHaralanov/gradle-plugin-template
      ```
    - Rename your project to have your desired plugin name.
    - Click **Clone** to download the project.

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
1. **Set Up the Gradle JVM:**
    - Open **File > Settings > Build, Execution, Deployment > Build Tools > Gradle**.
    - In the **Gradle JVM** dropdown, select **Download JDK**. 
    - Choose JDK Version **1.8**, Vendor is **Eclipse Temurin**, and keep the default location. 
    - Ensure the newly downloaded JDK is selected, then click **Apply** and **OK**.
2. **Configure the Project SDK:**
   - Open **File > Project Structure**.
   - Under Project Settings, set the SDK to **1.8** and Language Level to **SDK default**.
   - Click **Apply** and **OK**.

> [!IMPORTANT]
> - Update package names `org.example.plugin` accordingly.
> - Update `src/main/resources/plugin.yml` with your plugin details.
> - Update `settings.gradle` with your plugin name.
> - If you plan on publishing this plugin, you should update the documents within `.github` accordingly.

> [!NOTE]
> I've set the default API as CraftBukkit 1060 (CB1060).
> 
> If you wish to use [Project Poseidon](https://github.com/retromcorg/Project-Poseidon) or [UberBukkit](https://github.com/Moresteck/uberbukkit), you can go to their respective GitHub repositories and download the newest stable release.
> 
> Then you can replace `craftbukkit-1060.jar` inside the `libs` directory with your chosen API and edit the `build.gradle` dependency.

### Build Project
Once you finish developing your plugin, follow these steps to build and deploy it automatically using Gradle:
- Open the Gradle tab from the right-side menu in your IDE.
- Expand the `Tasks/custom` section.
- Double-click on the `replacePluginJar` task — it will:
  - Clean the project
  - Build a fresh `.jar`
  - Delete any previous version from your server’s `plugins` folder
  - Copy the new `.jar` directly into the server’s `plugins` directory
- Once it completes, simply start your Minecraft b1.7.3 server to load the updated plugin.

> [!CAUTION]
> It is crucial to set the `pluginsPath` variable in your `build.gradle` to point to your server’s plugins folder, for example:
> 
> `def pluginsPath = 'C:/MinecraftServer/plugins/'`

> [!TIP]
> If you want to exclude your plugin's version, retrieved from `plugin.yml`, from the plugin `.jar` file name, edit the `archiveFileName` field in `build.gradle` to `"${project.name}.jar"`.
