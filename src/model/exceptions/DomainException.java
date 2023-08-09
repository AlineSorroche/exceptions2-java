package model.exceptions;

public class DomainException extends RuntimeException {//se for RuntimeException o programa não obriga a tratar
	private static final long serialVersionUID = 1L;// o exeption é serializable(os objetos dessa classe podem ser convertidos para bytes e trafegar em redes e arquivos) assim ele precisa ter uma versão
	
	public DomainException(String msg) {//construtor que recebe um string como argumento
		super(msg);//repasso essa mensagem para o construtor da superclasse, permite que eu possa instanciar a minha exceção personalizada passando uma msg pra ela que vai ficar armazanada dentro da exceção
	}
	

}
