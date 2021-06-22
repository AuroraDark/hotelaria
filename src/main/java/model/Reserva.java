package model;

public class Reserva {

	private int codReserva;
	private String codCli;
	private String dataInicio;
	private String dataFim;
	
	public Reserva() {
		super();
	}

	public Reserva(int codReserva, String codCli, String dataInicio, String dataFim) {
		super();
		this.codReserva = codReserva;
		this.codCli = codCli;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "Reserva{" +
				"codReserva=" + codReserva +
				", codCli='" + codCli + '\'' +
				", dataInicio='" + dataInicio + '\'' +
				", dataFim='" + dataFim + '\'' +
				'}';
	}
}
