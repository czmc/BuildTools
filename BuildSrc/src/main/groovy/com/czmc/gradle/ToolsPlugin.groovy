package com.czmc.gradle

import com.czmc.gradle.task.JniMakeTask
import com.czmc.gradle.task.RemoteConnectTask;
import org.gradle.api.Plugin
import org.gradle.api.Project

public class ToolsPlugin implements Plugin<Project> {

    void apply(Project project) {
        System.out.println("========================");
        System.out.println("plugin初始化!");
        //加载资源
        Properties properties = new Properties()
        InputStream inputStream = project.rootProject.file('local.properties').newDataInputStream();
        properties.load(inputStream)
        //读取文件
        def sdkDir = properties.getProperty('sdk.dir')
        def deviceIp = properties.getProperty('device.ip')
        if (deviceIp == null) {
            System.err.println("在local.properties内找不到属性device.ip！");
        }
        if(sdkDir==null){
            System.err.println("在local.properties内找不到属性sdk.dir！");
        }
        project.extensions.create("JniMaker", JniMaker)
        project.extensions.add("sdkDir",sdkDir)
        project.extensions.add("deviceIp",deviceIp)
//        project.Param.extensions.create("InnerParam", InnerPluginExtension);
        project.task('makeJni', type: JniMakeTask)
        project.task('remoteConnect', type: RemoteConnectTask)
        System.out.println("========================");

    }

}

