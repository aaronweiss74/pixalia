package us.aaronweiss.pixalia.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * A set of static utilities for Pixalia.
 * @author Aaron Weiss
 * @version 1.0
 * @since alpha
 */
public class PixalUtils {
	private static String cachedIP = "";
	
	public static String getLocalHostname() {
		return System.getProperty("user.name") + "@localhost";
	}
	
	public static String getPublicHostname() {
		return System.getProperty("user.name") + "@" + PixalUtils.getIPAddress();
	}
	
	public static String getIPAddress() {
		if (cachedIP.isEmpty()) {
			String ip = "";
			try {
				URL whatismyip = new URL("http://api.externalip.net/ip/");
				BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
				ip = in.readLine();
			} catch (IOException e) {
				try {
					URL whatismyip = new URL("http://automation.whatismyip.com/n09230945.asp");
					BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
					ip = in.readLine();
				} catch (IOException ex) {
					ip = "0.0.0.0";
				}
			}
			cachedIP = ip;
		}
		return cachedIP;
	}
}
