package com.gencore.backend.java.utils;

public final class Convert {

	public static int stringToInt(String string, boolean eval) {
		if (eval == true) {
			// supprime les car differents d'un nombre [0..9]
			String str = "";
			char ch;
			for (int i = 0; i < string.length(); i++) {
				ch = string.charAt(i);
				if ((ch == '.') || (ch == ',')) {
					break;
				}
				if ((ch >= '0') && (ch <= '9')) {
					str = str + ch;
				}
			}
			return stringToInt(str);
		} else {
			return stringToInt(string);
		}
	}

	/**
	 * Converti une String en int si la chaine est null ou vide cela renvoie 0
	 * 
	 * @param string
	 *            chaine a transformer en int
	 * @return un int representant la chaine
	 */
	public static int stringToInt(String string) {
		int result = 0;
		if ((string != null) && (string.length() > 0)) {
			result = Integer.parseInt(string);
		}
		return result;
	}

	/**
	 * Converti une String en boolean si la chaine est non null et qu'elle
	 * contient "1" ou "true" alors on retournera true sinon false
	 * 
	 * @param string
	 *            chaine a transformer en int
	 * @return le boolean correspondant à la chaine
	 */
	public static boolean stringToBoolean(String string) {
		return ((string != null) && (string.equalsIgnoreCase("true")
				|| string.equalsIgnoreCase("1")
				|| string.equalsIgnoreCase("oui") || string
				.equalsIgnoreCase("vrai")));
	}

	/**
	 * Converti une String en short si la chaine est null ou vide cela renvoie 0
	 * 
	 * @param string
	 *            chaine a transformer en short
	 * @return un short representant la chaine
	 */
	public static short stringToShort(String string) {
		short result = 0;
		if ((string != null) && (string != "")) {
			if (string.length() != 0) {
				result = Short.parseShort(string);
			}
		}
		return result;
	}

	/**
	 * Converti une String en double si la chaine est null ou vide cela renvoie
	 * 0 la conversion focntionne idependemment du separateur decimal "." ou ","
	 * 
	 * @param string
	 *            chaine a transformer en double
	 * @return un double representant la chaine
	 */
	public static double stringToDouble(String string) {
		double result = 0;
		if ((string != null) && (string != "")) {
			string = string.replace(',', '.');
			if (string.length() != 0) {
				result = Double.parseDouble(string);
			}
		}
		return result;
	}

	/**
	 * Converti une String en long en permettant une evaluation de la chaine, a
	 * savoir si eval est à true on ignorera les caracteres parasites de la
	 * chaine si la chaine est null cela renvoie 0
	 * 
	 * exemple stringToLong("17.21%",true) donne 17.21
	 * 
	 * @param string
	 *            chaine a transformer en long
	 * @param eval
	 *            evaluation ou non
	 * @return un long representant la chaine
	 */
	public static long stringToLong(String string, boolean eval) {
		if (eval == true) {
			// supprime les car differents d'un nombre [0..9]
			String str = "";
			char ch;
			for (int i = 0; i < string.length(); i++) {
				ch = string.charAt(i);
				if ((ch == '.') || (ch == ',')) {
					break;
				}
				if ((ch >= '0') && (ch <= '9')) {
					str = str + ch;
				}
			}
			return stringToLong(str);
		} else {
			return stringToLong(string);
		}
	}

	/**
	 * Converti une String en long si la chaine est null ou vide cela renvoie 0
	 * 
	 * @param string
	 *            chaine a transformer en long
	 * @return un long representant la chaine
	 */

	public static long stringToLong(String string) {
		long result = 0;
		if ((string != null) && (string != "")) {
			if (string.length() != 0) {
				result = Long.parseLong(string);
			}
		}
		return result;
	}

	// /**
	// * Converti un double en une chaine representant un montant
	// *
	// * Exemple 11.2 donnera 11.20 Exemple 0 donnera 0.00
	// *
	// * @param value
	// * double a transformer en montant
	// * @return un String representant le double sous forme de montant
	// */
	// public static String doubleToStringMonnaie(double value) {
	// // TODO a faire en fonction du pays
	// String retour = NumberFormat.getFormat("###,##").format(value);
	// return retour;
	// }
	//
	// /**
	// * Converti un double en une chaine representant un pourcentage
	// *
	// * Exemple 11.2 donnera 1120% Exemple 11.2232 donnera 1122.32% Exemple
	// 11.2272 donnera 1122.72% Exemple 0 donnera
	// * 0.00%
	// *
	// * @param value
	// * double a transformer en pourcentage
	// * @return un String representant le double sous forme de pourcentage
	// */
	// public static String doubleToStringTaux(double value) {
	// // TODO a faire en fonction du pays
	// String retour = NumberFormat.getFormat("# ###,## %").format(value);
	// return retour;
	// }

	// methodes classiques
	public static String boolToString(boolean b) {
		if (b) {
			return "oui";
		} else {
			return "non";
		}
	}

	public static String intToString(int i) {
		return String.valueOf(i);
	}

	public static String intToString(Integer i) {
		if (i == null) {
			return "";
		}
		return String.valueOf(i);
	}

	public static Double intToDouble(int i) {
		return Double.valueOf(i);
	}

	public static String shortToString(short i) {
		return String.valueOf(i);
	}

	public static String doubleToString(double d) {
		return String.valueOf(d);
	}

	public static String doubleToString(Double d) {
		if (d == null) {
			return "";
		}
		return String.valueOf(d);
	}

	public static String longToString(long i) {
		return String.valueOf(i);
	}

}
