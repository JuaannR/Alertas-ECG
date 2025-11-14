package clasesProyecto;

public class ContadorCiclos {
	private int cicloActual;
	private int cicloAnterior;


		public ContadorCiclos() {
			this.cicloActual = 0;
			this.cicloAnterior = cicloActual - 1;
		}


		public int getCicloActual() {
			return cicloActual;
		}


		public void setCicloActual(int cicloActual) {
			this.cicloActual = cicloActual;
		}


		public int getCicloAnterior() {
			return cicloAnterior;
		}


		public void setCicloAnterior(int cicloAnterior) {
			this.cicloAnterior = cicloAnterior;
		}
		
		
		
}