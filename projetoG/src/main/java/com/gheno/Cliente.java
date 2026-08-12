public class Cliente{
  private String nome;
  private String cpf;
  private int pontos;
  private double valor

  public Cliente(){
    nome="";
    cpf="";
    pontos=0;
    valor=0;
  }

  public Cliente(String nome, String cpf, int pontos){
    this.nome = nome;
    this.cpf = cpf;
    this.pontos = pontos;
  }

  public String getNome() {
    return nome;
  }


  public String getCpf() {
    return cpf;
  }


  public int getPontos() {
    return pontos;
  }

  public double getValor(){
    return valor;
  }

  public double calculaPontos(int pontos, double valor){
    if(valor<500){
        valor = valor/100;
        valor = Math.round(valor);
    }
    else{
        valor = valor/500;
        Math.round(valor);
        valor = valor*5;
    }
  }

}
