
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		venilton.setSobreNome("Santos");

		Cliente rafael = new Cliente();
		rafael.setNome("Rafael");
		rafael.setSobreNome("Farias");

		Cliente rodrigo = new Cliente();
		rodrigo.setNome("Rodrigo");
		rodrigo.setSobreNome("Silva");


		Conta contaCorrenteVenilton = new ContaCorrente(venilton);
		Conta poupancaRafael = new ContaPoupanca(rafael);
		Conta contaCorrenteRodrigo = new ContaCorrente(rodrigo);


		contaCorrenteVenilton.depositar(10000);
		poupancaRafael.depositar(1500000);
		contaCorrenteRodrigo.depositar(80000);
//		contaCorrenteVenilton.transferir(1200, poupancaRafael);
//		contaCorrenteVenilton.transferir(3000, contaCorrenteRodrigo);


		contaCorrenteVenilton.imprimirExtrato();
		poupancaRafael.imprimirExtrato();
		contaCorrenteRodrigo.imprimirExtrato();
	}

}
