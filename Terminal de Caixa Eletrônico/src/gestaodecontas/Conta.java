
package gestaodecontas;

public class Conta {
    
    private int numero;
    private int senha;
    private double saldo;
    private Lancamento[] lancamentos;
    private int ultimoLancamento;
	
    public Conta(int numero, int senha, double saldo) {
	this.numero = numero;
	this.senha = senha;
	this.saldo = saldo;
	this.lancamentos = new Lancamento[11];
    }
	
    public int getNumero() {
	return this.numero;
    }
	
    public double verificaSaldo(int senha) {
	if (senha != this.senha) {
            return -1;
	}
	else {
            return this.saldo;
	}
    }
	
    public boolean debitaValor(int senha, double valor, String operacao) {
	if (senha != this.senha | valor > this.saldo | valor < 0) {
            return false;
	}
	if (this.ultimoLancamento == 10) {
            for (int i = 0; i < 10; i++) {
		this.lancamentos[i] = this.lancamentos[i + 1];
            }
	}
	else {
            this.ultimoLancamento++;
	}
	this.lancamentos[this.ultimoLancamento] = new Lancamento(operacao, valor);
	this.saldo -= valor;
	return true;
    }	
}