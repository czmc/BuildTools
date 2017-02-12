package com.czmc.gradle.task;

import org.gradle.api.tasks.Exec

/**
 * Created by czmc on 2017/2/9.
 */

public class JniMakeTask extends Exec {

    @Override
    protected void exec() {
        def compileSdk = "${project.sdkDir}/platforms/${project.android.compileSdkVersion}/android.jar;${project.sdkDir}/extras/android/support/v7/appcompat/libs/*;"
        def targetFile = project.buildDir.absolutePath+"\\intermediates\\classes\\debug"
        System.out.println("compile SDK:"+compileSdk)
        System.out.println("compile extra path:"+project.JniMaker.entraClassPath)
        System.out.println("target file:"+targetFile)
        commandLine 'cmd',"/c","javah -d  ${project.JniMaker.buildSrc} -classpath ${targetFile};${compileSdk};${project.JniMaker.entraClassPath} ${project.JniMaker.targetClass}"
        System.out.println("remoteConnect Exec..");
        super.exec()
    }
}
