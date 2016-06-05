package fr.myrilandel.hordemod.utils;

public class PosHelper {
	
	public static boolean isEnVille(double x, double z) {
		return x > 912 && x < 990 && z > 1012 && z < 1090;
	}
	
	public static int getHMPosX(double x) {
		return (int) (x/100-9);
	}

	public static int getHMPosZ(double z) {
		return (int) (z/100-10);
	}
}
