package model;

public class Nguoi {
    
    protected String ten, soCMND;
    protected int tuoi;

    public Nguoi(String ten, String soCMND, int tuoi) {
        this.ten = ten;
        this.soCMND = soCMND;
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "Nguoi{" + "ten=" + ten + ", soCMND=" + soCMND + ", tuoi=" + tuoi + '}';
    }
    
    


    
}
