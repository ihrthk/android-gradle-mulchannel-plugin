## android-gradle-mulchannel-plugin

Gradle plugin for multiple channel apks

![demo](art/demo.png "dd")

## Contents
 * [Overview](#over_view )
 * [Supported features](#support_features)
 * [Theory](#theory)
 * [Testing](#testing)
 * [Use plugin](#use_plugin)
       * [In Remote(Not need clone thie project to use,require gradle 2.1)](#in_remote)
       * [In Local(Need clone this project to use)](#in_local)
 * [Get channel](#get_channel)
 * [Set channel](#set_channel)
 * [Check signature](#check_signature)
 * [License](#license)


## <a id="over_view"></a>Overview

This plugin generates multiple apks from different channel.
Generation has to be invoked as additions gradle task.

## <a id="support_features"/>Supported features

 * inputFile-config input file
 * tempDir-config unzip dir
 * outputDir-config output dir
 * channels-config multiple channels

## <a id="theory"></a>Theory

If adding empty file in "META-INF" directory, do not need to sign the application.Therefore, by adding different empty file for the application of the different channels, can be the only one channel.

## <a id="testing"></a>Testing

![demo](art/test.png "test")
Rate = 10apk/20sec(300apk/10min)

## <a id="use_plugin"/>Use plugin
### <a id="in_remote"/>In Remote(Not need clone thie project to use,require gradle 2.1)
1.Add plugin declare in __build.gradle__ file

    buildscript {
      repositories {
        mavenLocal()
        jcenter {
            url 'http://jcenter.bintray.com'
        }
      }
    }
    plugins {
      id "me.zhangls.mulchannel" version "0.0.2"
    }
    
2.Config mulchannel extension(inputFile,tempDir,outputDir,channels),eg:

    mulchannel {
        inputFile = file('lite-cmxj-debug.apk')
        tempDir = file('temp')
        outputDir = file('out')
        channels = ["qihu360","baidu","yingyongbao","wandoujia","taobao","xiaomi","nearme","anzhuo","anzhi","meizu"]
    }

3.Use `gradle mulchannel` to make multiple channel apks
### <a id="in_local"/>In Local(Need clone this project to use)

1.Use `gradle install` command,To install the plug in local maven

2.Add dependency to the __top-level__ `build.gradle` file.
    
    buildscript {
        repositories {
            mavenLocal()
        }
        dependencies {
            classpath 'me.zhangls:mulchannel:0.0.2'
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

## <a id="get_channel"/>Get channel

public static String getChannel(Context context) {
  ApplicationInfo appinfo = context.getApplicationInfo();
  String sourceDir = appinfo.sourceDir;
  String ret = "";
  ZipFile zipfile = null;
  try {
      zipfile = new ZipFile(sourceDir);
      Enumeration<?> entries = zipfile.entries();
      while (entries.hasMoreElements()) {
          ZipEntry entry = ((ZipEntry) entries.nextElement());
          String entryName = entry.getName();
          if (entryName.startsWith("META-INF/mulchannel")) {
              ret = entryName;
              break;
          }
      }
  } catch (IOException e) {
      e.printStackTrace();
  } finally {
      if (zipfile != null) {
          try {
              zipfile.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }

  String[] split = ret.split("_");
  if (split != null && split.length >= 2) {
      return ret.substring(split[0].length() + 1);

  } else {
      return "";
  }
}

## <a id="set_channel"/>Set channel

   Will `<meta-data android:value="Channel ID" android:name="UMENG_CHANNEL"/>`<br>
   Channel ID replace the name of the marketing channels you apply<br>
   e.g. `<meta-data android:value="Wandoujia" android:name="UMENG_CHANNEL"/>`<br>
    
   If you don't want to in __AndroidManifest.xml__ to config channel of __umeng__,you can also in __Activity__ to config.<br>
   Please in launch activity to involved this method:`AnalyticsConfig.setChannel(String channel)`

## <a id="check_signature"/>Check signature
   
   [keytool -list -printcert -jarfile app.apk](http://stackoverflow.com/questions/11331469/how-to-find-out-which-key-was-used-to-sign-an-app)<br>
   The output will reveal the signature owner/issuer and MD5, SHA1 and SHA256 fingerprints.
    

## <a id="license"/>License

   MIT License
   See [LICENSE](https://github.com/ihrthk/android-gradle-mulchannel-plugin/blob/master/LICENSE) file.
