package operacao;

class Deposita implements Operacao {

    @Override
    public void realizar() {
        System.out.println("Depositou");
    }
}
