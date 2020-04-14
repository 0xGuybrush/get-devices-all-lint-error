# Steps to reproduce

* Build and deploy app to a phone or emulator
* Notice that it will toast with Audio Device attached, both sink and source
* Run `./gradlew lintRelease`

## Current outcome

Build fails with lint warning:

```
Errors found:
  
  /app/src/main/java/ie/davidmoloney/getdevicesall/MainActivity.java:35: Error: Must be one or more of: AudioManager.GET_DEVICES_INPUTS, AudioManager.GET_DEVICES_OUTPUTS [WrongConstant]
          final AudioDeviceInfo[] devices = audioManager.getDevices(GET_DEVICES_ALL);
                                                                    ~~~~~~~~~~~~~~~
```

## Desired outcome

* Linting passes successfully, as we are using `GET_DEVICES_ALL` when targeting ≥ API level 23.
