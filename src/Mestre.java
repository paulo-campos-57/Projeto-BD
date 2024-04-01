package src

public class Mestre extends User {
    private String npc;
    private String monstros;

    public Mestre(String npc, String monstros) {
        this.npc = npc;
        this.monstros = monstros;
    }

    public Mestre() {
        super();
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }

    public String getMonstros() {
        return monstros;
    }

    public void setMonstros(String monstros) {
        this.monstros = monstros;
    }
}