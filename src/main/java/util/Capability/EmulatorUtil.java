package util.Capability;

import java.io.IOException;

import util.Common.BaseClass;

public class EmulatorUtil extends BaseClass{

	public void startEmulator(String avdName) {
		String StartEmulator= "emulator -avd "+avdName+" -netdelay none -netspeed full";
		try {
			Runtime.getRuntime().exec(StartEmulator);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void stopEmulator(String emulator) {
		String StopEmulator = "adb -s "+emulator+" emu kill";
		try {
			Runtime.getRuntime().exec(StopEmulator);
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
