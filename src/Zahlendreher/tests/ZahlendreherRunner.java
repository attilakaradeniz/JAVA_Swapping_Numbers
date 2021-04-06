package Zahlendreher.tests;



import java.util.Locale;


public class ZahlendreherRunner {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("US", "en"));
		//System.out.printf("[ZahlendreherRunner] calling Zahlendreher.Main.main: ");
		Zahlendreher.Main.main(args);

	}

}
