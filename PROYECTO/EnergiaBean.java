package PROYECTO;

public class EnergiaBean {
	
	public EnergiaBean() {
		
	}

	private double masa;

	private double deformacion;

	private double velocidad;

	private double altura;
	
	private double constanteElasticidad;

	public double getMasa() {
		return masa;
	}

	public double getDeformacion() {
		return deformacion;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public double getAltura() {
		return altura;
	}

	public double getConstanteElasticidad() {
		return constanteElasticidad;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public void setDeformacion(double deformacion) {
		this.deformacion = deformacion;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setConstanteElasticidad(double constanteDeformacion) {
		this.constanteElasticidad = constanteDeformacion;
	}

	@Override
	public String toString() {
		return "EnergiaBean [masa=" + masa + ", deformacion=" + deformacion + ", velocidad=" + velocidad + ", altura="
				+ altura + ", constanteDeElasticidad=" + constanteElasticidad + "]";
	}

	

}