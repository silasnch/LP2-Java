
package gestaodecontas;

public class Lancamento {
    
    private String operacao;
    private double valor;
	
    public Lancamento(String operacao, double valor) {
	this.operacao = operacao;
	this.valor = valor;
    }
	
    public String getOperacao() {
	return this.operacao;
    }
	
    public double getValor() {
	return this.valor;
    }
	
    public String toString() {
	return "Operacao: " + this.operacao +
		"\tValor: " + this.valor;
    }
   
}