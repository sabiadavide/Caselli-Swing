package it.unibas.caselli.modello;

public class Accesso {
    
    private String targa;
    private String marca;
    private double costo;
    private String pagamento;

    public Accesso(String targa, String marca, double costo, String pagamento) {
        this.targa = targa;
        this.marca = marca;
        this.costo = costo;
        this.pagamento = pagamento;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Accesso{");
        sb.append("targa=").append(targa);
        sb.append(", marca=").append(marca);
        sb.append(", costo=").append(costo);
        sb.append(", pagamento=").append(pagamento);
        sb.append('}');
        return sb.toString();
    }
    
}
