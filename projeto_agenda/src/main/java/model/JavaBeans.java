package model;





// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The id contatos. */
	private String idContatos;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The email. */
	private String email;
	
	
	
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}
	
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idContatos the id contatos
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 */
	public JavaBeans(String idContatos, String nome, String fone, String email) {
		super();
		this.idContatos = idContatos;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}


	/**
	 * Gets the id contatos.
	 *
	 * @return the id contatos
	 */
	public String getIdContatos() {
		return idContatos;
	}
	
	/**
	 * Sets the id contatos.
	 *
	 * @param idContatos the new id contatos
	 */
	public void setIdContatos(String idContatos) {
		this.idContatos = idContatos;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}
	
	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
