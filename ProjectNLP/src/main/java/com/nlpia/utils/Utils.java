package com.nlpia.utils;

import java.io.File;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nlpia.document.Token;

public class Utils {

	public static String checkTokenType(Token token) {

		try {

			Double.parseDouble(token.getContent());

			return "Number";

		} catch (Exception e) {
			
		}

		if (Utils.isSymbol(token.getContent())) {
			return "Symbol";
		}

		return "Word";
	}

	private static boolean isSymbol(String token) {

		token = token.replaceAll("_", "+");
		Pattern pattern = Pattern.compile("(\\W)+");
		Matcher matcher = pattern.matcher(token);

		return matcher.matches();
	}

	public static Set<String> loadSetOfWords(File file) throws Exception {

		try {

			String content = Utils.readTxtFile(file);
			if (content == null) {
				return null;
			}

			String[] lines = content.split("\r?\n");
			Set<String> words = new HashSet<String>();

			for (String line : lines) {
				words.add(Utils.normalizeString(line.toLowerCase()));
			}

			return words;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static String readTxtFile(File txtFile) {
		// TODO Auto-generated method stub

		FileReader fileReader = null;

		try {
			fileReader = new FileReader(txtFile);

			// LENDO O ARQUIVO E PEGANDO CADA CARACTER

			char[] chars = new char[(int) txtFile.length()];
			fileReader.read(chars);

			return new String(chars);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				fileReader.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}

		return null;
	}
	
	private static String normalizeString(String text) {
		// TODO Auto-generated method stub
		if(text == null) {
			return null;
		}
		
		text = Normalizer.normalize(text, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
		text = text.replaceAll("\\p{P}", "");
		text = text.toLowerCase();
		
		return text.trim();
	}
}
