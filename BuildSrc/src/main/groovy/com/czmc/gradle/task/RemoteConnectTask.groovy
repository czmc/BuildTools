package com.czmc.gradle.task;

import org.gradle.api.tasks.Exec

/**
 * Created by czmc on 2017/2/9.
 */

public class RemoteConnectTask extends Exec {

    @Override
    protected void exec() {
        commandLine 'cmd', "/c", "${project.sdkDir}\\platform-tools\\adb  tcpip 5555"
        commandLine 'cmd', "/c","${project.sdkDir}\\platform-tools\\adb connect ${project.deviceIp}"
        System.out.println("remoteConnect Exec..");
        super.exec()
    }
}
