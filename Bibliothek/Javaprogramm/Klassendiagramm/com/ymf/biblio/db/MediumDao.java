package Klassendiagramm.com.ymf.biblio.db;


/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public interface MediumDao {



	/**
	 * 
	 * @param medium
	 */
	public void mediumEntfernen(int medium);

	public void mediumHinzufuegen();

}