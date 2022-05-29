import java.math.BigDecimal;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public Conta() {
	}

	@Override
	public void sacar(double valor) {
		if (getSaldo() > valor) {
			saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public void depositar(double valor) {
		if (valor > 0 && valor <= 10) {
			saldo += valor;
		} else if (valor > 10 && valor <=10000){
			saldo += valor + (valor / 100) * 0.05;
		} else if (valor > 10000){
			saldo += valor + (valor / 100) * 0.02;
		} else {
			System.out.println("Valor deve ser superior a R$ 0,00");
		}
	}

//	@Override
//	public void depositar(double valor) {
//		if (valor > 0) {
//			saldo += valor;
//		} else {
//			System.out.println("Valor deve ser superior a R$ 10,00");
//		}
//	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (this.getSaldo() > valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			System.out.println("Saldo insuficiente: " + "Saldo: " + this.saldo + ", Valor a transferir: " + valor +
					" para a conta de " + cliente.getNome());
		}
	}

	public int getAgencia(Cliente cliente) {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome() + " " + this.cliente.getSobreNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
