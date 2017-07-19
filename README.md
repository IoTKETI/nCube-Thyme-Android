# &Cube-Thyme for Android
## Introduction
&Cube-Thyme is an open source IoT device application entity based on the oneM2M (http://www.oneM2M.org) standard. &Cube-Thyme consists of three versions: Node.js version, Java version and Android version.

## Connectivity stucture
&Cube-Thyme implementation of oneM2M ADN-AE can be connected to MN-CSE or IN-CSE.
<div align="center">
<img src="https://user-images.githubusercontent.com/29790334/28315421-497cf0b4-6bf9-11e7-9e67-61e4c351c035.png" width="600"/>
</div>

## Developement Environment
&Cube-Thyme for Android is written in Java targeting Android application.
- [JDK(Java Development Kit)]
Download and install Java SE JDK at ORACLE website from the URL.(http://www.oracle.com/technetwork/java/javase/downloads/index.html)
<div align="center">
<img src="https://user-images.githubusercontent.com/29790334/28374986-4556eae2-6ce1-11e7-9867-6e36660cda05.png" width="800"/>
</div><br/>
- [Android Studio]
Download and install Android Studio from the URL.(https://developer.android.com/studio/index.html)
<div align="center">
<img src="https://user-images.githubusercontent.com/29790334/28378125-0fa6ee8e-6cea-11e7-8cf1-149d486927f5.png" width="800"/>
</div><br/>

## Configuration
- Open the &Cube-Thyme for Android project
- Modify default configuration file "nCubeSetting.java" per your setting
```
{
    "useprotocol": "http",
    "cse": {
        "cbhost": "203.253.128.161",    //CSE host IP
        "cbport": "7579",               //CSE http hosting port
        "cbname": "Mobius",
        "cbcseid": "/Mobius",
        "mqttport": "1883"              //CSE mqtt broaker port
    },
    "ae": {
        "aeid": "S",
        "appid": "0.2.481.1.1",
        "appname": "ae-test1",          //AE name
        "appport": "9727",
        "bodytype": "xml",
        "tasport": "3105"
    },
    "cnt": [
        {
            "parentpath": "/ae-test1",
            "ctname": "cnt-co2"
        },
        {
            "parentpath": "/ae-test1",
            "ctname": "cnt-led"
        }
    ],
    "sub": [
        {
            "parentpath": "/ae-test1/cnt-led",
            "subname": "sub-ctrl",
            "nu": "mqtt://AUTOSET"
        }
    ]

```

## Dependency External Libraries
This is the list of external library dependencies for &Cube:Thyme Android 
- org.json
- org.apache.http
- org.eclipse.paho.client.mqttv3

## Document
If you want more details please dowload the full [installation guide document](https://github.com/IoTKETI/nCube-Thyme-Java/raw/master/doc/(English)%20nCube-Thyme-Java.pdf).

# Author
Nak-Myoung Sung (nmsung@keti.re.kr; diesnm201@gmail.com)
