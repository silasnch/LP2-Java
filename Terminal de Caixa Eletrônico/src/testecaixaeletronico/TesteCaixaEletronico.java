
package testecaixaeletronico;

import gestaodecontas.Conta;
import gestaodecontas.CadastroContas;
import gestaodecaixaeletronio.Caixa;
import gestaodecaixaeletronio.Terminal;

public class TesteCaixaEletronico {
    
    public static void main(String[] args) {
     
        Conta c1 = new Conta(1, 1234, 600);
        Conta c2 = new Conta(2, 1234, 800);
        Conta c3 = new Conta(3, 1234, 1000);
        Conta c4 = new Conta(4, 1234, 400);
        
        CadastroContas cc = new CadastroContas(4);
        
        cc.insereConta(c1);
        cc.insereConta(c2);
        cc.insereConta(c3);
        cc.insereConta(c4);
        
        Terminal atm = new Terminal(cc);
        
        atm.iniciaOperacao();
        
    }
    
}