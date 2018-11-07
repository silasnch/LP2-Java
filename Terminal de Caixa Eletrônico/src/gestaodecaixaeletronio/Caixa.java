
package gestaodecaixaeletronio;

import gestaodecontas.CadastroContas;
import gestaodecontas.Conta;

public class Caixa {
    
    private Terminal meuCaixaEletronico;
    private CadastroContas bdContas;
    private double saldoCaixa;
	
    public Caixa(Terminal terminal, CadastroContas bd) {
	this.meuCaixaEletronico = terminal;
	this.bdContas = bd;
    }
	
    public double consultaSaldo(int numeroDaConta, int senha) {
	Conta conta;
	conta = this.bdContas.buscaConta(numeroDaConta);
		
	if (conta != null) {
            return conta.verificaSaldo(senha);
	}
	else {
            return -1;
	}
    }
	
    public boolean efetuaSaque(int numeroDaConta, double valor, int senha) {
	if (valor < 0 || (valor%50) != 0 || valor > 500 || valor > this.saldoCaixa) {
            return false;
	}
	Conta conta = bdContas.buscaConta(numeroDaConta);
		
	if (conta == null || !conta.debitaValor(senha, valor, "Saque Automatico")) {
            return false;
	}
	this.liberaNotas((int) valor/50);
	this.saldoCaixa -= valor;
		
	if (this.saldoCaixa < 500) {
            this.meuCaixaEletronico.setModo(0);
	}
	return true;
    }
	
    public void recarrega() {
	this.saldoCaixa = 1000;
	this.meuCaixaEletronico.setModo(1);
    }
	
    public void liberaNotas(int qtd) {
	while (qtd-- > 0) {
            System.out.println("===/ R$ 50,00 /===");
	}
    }
    
}