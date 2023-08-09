package model.exceptions;

public class DomainException extends RuntimeException {//se for RuntimeException o programa n�o obriga a tratar
	private static final long serialVersionUID = 1L;// o exeption � serializable(os objetos dessa classe podem ser convertidos para bytes e trafegar em redes e arquivos) assim ele precisa ter uma vers�o
	
	public DomainException(String msg) {//construtor que recebe um string como argumento
		super(msg);//repasso essa mensagem para o construtor da superclasse, permite que eu possa instanciar a minha exce��o personalizada passando uma msg pra ela que vai ficar armazanada dentro da exce��o
	}
	

}
