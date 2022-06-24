package Klassendiagramm.com.ymf.biblio.gemeinsam;


/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class Medium {

	public Medium(String autor, String genre, String titel) {
		this.autor = autor;
		this.genre = genre;
		this.titel = titel;
	}

	private int altersfreigabe;
	private String autor;
	private String genre;
	private int id;
	private int stadortCode;
	private String titel;
	private Mediumart art;

	public Medium(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param mediumId
	 */
	public void mediumEntfernen(long mediumId){

	}

	/**
	 * 
	 * @param mediumId
	 */
	public void mediumErstellen(long mediumId){

	}


	public int getAltersfreigabe() {
		return altersfreigabe;
	}

	public void setAltersfreigabe(int altersfreigabe) {
		this.altersfreigabe = altersfreigabe;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStadortCode() {
		return stadortCode;
	}

	public void setStadortCode(int stadortCode) {
		this.stadortCode = stadortCode;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Mediumart getArt() {
		return art;
	}

	public void setArt(Mediumart art) {
		this.art = art;
	}
}