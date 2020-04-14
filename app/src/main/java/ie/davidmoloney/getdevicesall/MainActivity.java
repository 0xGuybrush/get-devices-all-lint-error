package ie.davidmoloney.getdevicesall;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Arrays;

import static android.media.AudioDeviceInfo.*;
import static android.media.AudioManager.GET_DEVICES_ALL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioManager == null) {
            Toast.makeText(this, "Could not retrieve AudioManager", Toast.LENGTH_SHORT).show();
        } else {
            final String[] deviceNames = getAudioDeviceInfoNames(audioManager);
            Toast.makeText(this, Arrays.toString(deviceNames), Toast.LENGTH_LONG).show();
        }
    }

    private String[] getAudioDeviceInfoNames(final AudioManager audioManager) {
        final AudioDeviceInfo[] devices = audioManager.getDevices(GET_DEVICES_ALL);
        final String[] deviceNames = new String[devices.length];
        for (int i = 0; i < devices.length; i++) {
            final int deviceType = devices[i].getType();
            switch (deviceType) {
                case TYPE_AUX_LINE:
                    deviceNames[i] = "TYPE_AUX_LINE";
                    break;
                case TYPE_BLUETOOTH_A2DP:
                    deviceNames[i] = "TYPE_BLUETOOTH_A2DP";
                    break;
                case TYPE_BLUETOOTH_SCO:
                    deviceNames[i] = "TYPE_BLUETOOTH_SCO";
                    break;
                case TYPE_BUILTIN_EARPIECE:
                    deviceNames[i] = "TYPE_BUILTIN_EARPIECE";
                    break;
                case TYPE_BUILTIN_MIC:
                    deviceNames[i] = "TYPE_BUILTIN_MIC";
                    break;
                case TYPE_BUILTIN_SPEAKER:
                    deviceNames[i] = " TYPE_BUILTIN_SPEAKER";
                    break;
                case TYPE_BUS:
                    deviceNames[i] = "TYPE_BUS";
                    break;
                case TYPE_DOCK:
                    deviceNames[i] = "TYPE_DOCK";
                    break;
                case TYPE_FM:
                    deviceNames[i] = "TYPE_FM";
                    break;
                case TYPE_FM_TUNER:
                    deviceNames[i] = "TYPE_FM_TUNER";
                    break;
                case TYPE_HDMI:
                    deviceNames[i] = "TYPE_HDMI";
                    break;
                case TYPE_HDMI_ARC:
                    deviceNames[i] = "TYPE_HDMI_ARC";
                    break;
                case TYPE_HEARING_AID:
                    deviceNames[i] = "TYPE_HEARING_AID";
                    break;
                case TYPE_IP:
                    deviceNames[i] = "TYPE_IP";
                    break;
                case TYPE_LINE_ANALOG:
                    deviceNames[i] = "TYPE_LINE_ANALOG";
                    break;
                case TYPE_LINE_DIGITAL:
                    deviceNames[i] = "TYPE_LINE_DIGITAL";
                    break;
                case TYPE_TELEPHONY:
                    deviceNames[i] = "TYPE_TELEPHONY";
                    break;
                case TYPE_TV_TUNER:
                    deviceNames[i] = "TYPE_TV_TUNER";
                    break;
                case TYPE_UNKNOWN:
                    deviceNames[i] = "TYPE_UNKNOWN";
                    break;
                case TYPE_USB_ACCESSORY:
                    deviceNames[i] = "TYPE_USB_ACCESSORY";
                    break;
                case TYPE_USB_DEVICE:
                    deviceNames[i] = "TYPE_USB_DEVICE";
                    break;
                case TYPE_USB_HEADSET:
                    deviceNames[i] = "TYPE_USB_HEADSET";
                    break;
                case TYPE_WIRED_HEADPHONES:
                    deviceNames[i] = "TYPE_WIRED_HEADPHONES";
                    break;
                case TYPE_WIRED_HEADSET:
                    deviceNames[i] = "TYPE_WIRED_HEADSET";
                    break;
                default:
                    deviceNames[i] = "__INT_CODE_MISSING_FROM_LIST__";
             }
        }
        return deviceNames;
    }
}
