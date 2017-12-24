package com.gencore.backend.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractGetData extends BaseTest{

	public abstract void insertData(String [] line);
	
	private String filePath;
	
	public void setFilePath (String filePath) {
		this.filePath = filePath;
	}

	public void processData() throws IOException {
		
		try {

			BufferedReader fichier_source = new BufferedReader(new FileReader(
					this.filePath));
			String chaine;
			int i = 1;

			while ((chaine = fichier_source.readLine()) != null) {
				String[] tabChaine = chaine.split(";");
				// Tu effectues tes traitements avec les données contenues dans
				// le tableau
				// La première information se trouve à l'indice 0
				insertData(tabChaine);
			}
			fichier_source.close();
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier est introuvable !");
		}

	}
}
