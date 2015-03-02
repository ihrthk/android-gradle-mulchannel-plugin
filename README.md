## android-gradle-mulchannel-plugin

Gradle plugin for multiple channel apks

## Contents
 * [Overview](#Overview)


## <a id="Overview"></a>Overview

This plugin generates multiple apks from different channel.
Generation has to be invoked as additions gradle task.

##Supported features

 * inputFile-config input file
 * tempDir-config unzip dir
 * outputDir-config output dir
 * channels-config multiple channels

##Use plugin
###In Remote(Not need clone thie project to use)
1.Add dependency to the __top-level__ `build.gradle` file.
    
    buildscript {
        repositories {
            jcenter()
        }
        dependencies {
            classpath ' classpath 'me.zhangls:android-mulchannel-plugin:0.0.1''
        }
    }
2.Apply plugin and add configuration to `build.gradle` of the application, eg:

    apply plugin: 'mulchannel'
    
3.Config mulchannel extension(inputFile,tempDir,outputDir,channels),eg:

    mulchannel {
        inputFile = file('lite-cmxj-debug.apk')
        tempDir = file('temp')
        outputDir = file('out')
        channels = ["qihu360","baidu","yingyongbao","wandoujia","taobao","xiaomi","nearme","anzhuo","anzhi","meizu"]
    }

4.Use `gradle mulchannel` to make multiple channel apks
###In Local(Need clone this project to use)

1.Use `gradle install` command,To install the plug in local maven

2.Add dependency to the __top-level__ `build.gradle` file.
    
    buildscript {
        repositories {
            mavenLocal()
        }
        dependencies {
            classpath 'me.zhangls:mulchannel:0.0.1'
        }
    }

3.Apply plugin and add configuration to `build.gradle` of the application, eg:

    apply plugin: 'mulchannel'

4.Config mulchannel extension(inputFile,tempDir,outputDir,channels),eg:

    mulchannel {
        inputFile = file('lite-cmxj-debug.apk')
        tempDir = file('temp')
        outputDir = file('out')
        channels = ["qihu360","baidu","yingyongbao","wandoujia","taobao","xiaomi","nearme","anzhuo","anzhi","meizu"]
    }

5.Use `gradle mulchannel` to make multiple channel apks


##License

MIT License
See LICENSE file.
