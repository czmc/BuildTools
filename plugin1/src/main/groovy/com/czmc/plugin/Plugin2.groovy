package  com.czmc.plugin;

import org.gradle.api.Plugin
import org.gradle.api.Project

public class Plugin2 implements Plugin<Project> {

    void apply(Project project) {
        System.out.println("========================");
        System.out.println("hello gradle plugin!");
        System.out.println("========================");
    }
}