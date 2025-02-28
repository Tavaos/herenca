abstract class Veiculo {
    String marca, modelo, combustivel;
    int ano, capacidadePassageiros;

    public Veiculo(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.capacidadePassageiros = capacidadePassageiros;
        this.combustivel = combustivel;
    }

    public abstract double calcularAutonomia();

    public void exibirDetalhes() {
        System.out.println(marca + " " + modelo + " - " + ano);
    }
}

class Carro extends Veiculo {
    public Carro(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
    }

    @Override
    public double calcularAutonomia() {
        return 50 * 12;
    }
}

class Caminhao extends Veiculo {
    double capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, double capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAutonomia() {
        return 300 * (6 * (1 - Math.min(capacidadeCarga * 0.01, 0.25)));
    }
}

class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 5, "Gasolina");
        Caminhao caminhao = new Caminhao("Volvo", "FH16", 2021, 2, "Diesel", 10);

        carro.exibirDetalhes();
        System.out.println("Autonomia: " + carro.calcularAutonomia() + " km");

        caminhao.exibirDetalhes();
        System.out.println("Autonomia: " + caminhao.calcularAutonomia() + " km");
    }
}
