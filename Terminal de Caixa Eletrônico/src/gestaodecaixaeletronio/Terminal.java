
package gestaodecaixaeletronio;

import java.util.Scanner;
import gestaodecontas.CadastroContas;

public class Terminal {
    
    private Caixa meuCaixa;
    private int modoAtual;
	
    public Terminal(CadastroContas bd) {
	this.meuCaixa = new Caixa(this, bd);
    }
	
    public void iniciaOperacao() {
	int opcao;
	opcao = this.getOpcao();
		
	while (opcao != 4) {
			
            switch (opcao) {
			
            case 1:
		double saldo = this.meuCaixa.consultaSaldo(getInt("Numero da conta"), getInt("Senha:"));
                if (saldo != -1) {
                    System.out.println("Saldo atual: " + saldo);
                }
                else {
                    System.out.println("Conta ou senha invalidas");
                }
                break;
                
            case 2:
                boolean b = this.meuCaixa.efetuaSaque(getInt("Numero da conta"), (double) getInt("Valor"), getInt("Senha"));
                if (b) {
                    System.out.println("Retire o dinheiro");
                }
                else {
                    System.out.println("Pedido de saque recusado");
                }
                break;
                
            case 3:
                this.meuCaixa.recarrega();
                break;
            }
            opcao = getOpcao();
	}
    }
    
    public void setModo(int modo) {
        if (modo == 0 || modo == 1) {
            this.modoAtual = modo;
        }
    }
    
    private int getOpcao() {
        int opcao;
        do {
            if (this.modoAtual == 1) {
                opcao = getInt("Opcao: 1-Consulta, 2-Saque, 4-Sair");
                if (opcao != 1 & opcao != 2 & opcao != 4) {
                    opcao = 0;
                }
            }
            else {
                opcao = getInt("Opcao: 3-Recarrega, 4-Sair");
                if (opcao != 3 & opcao != 4) {
                    opcao = 0;
                }
            } 
        } while (opcao == 0);
        return opcao;
    }
    
    private int getInt(String string) {
        Scanner r = new Scanner(System.in);
        System.out.println("Entre com " + string);
        
        if (r.hasNextInt()) {
            return r.nextInt();
        }
        String st = r.next();
        System.err.println("Erro na leitura dos dados");
        return 0;
    }
    
}