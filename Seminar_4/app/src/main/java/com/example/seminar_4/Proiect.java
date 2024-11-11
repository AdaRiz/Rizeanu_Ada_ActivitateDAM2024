package com.example.seminar_4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Proiect implements Parcelable {
    private String nume;
    private int durata;
    private TipProiect tip;
    private float rating;
    private boolean esteActiv;
    private String[] echipa;

    public Proiect(String nume, int durata, TipProiect tip,float rating, boolean esteActiv, String[] echipa) {
        this.nume = nume;
        this.durata = durata;
        this.tip = tip;
        this.rating = rating;
        this.esteActiv = esteActiv;
        this.echipa = echipa;
    }

    protected Proiect(Parcel in)
    {
        nume = in.readString();
        durata = in.readInt();
        tip=TipProiect.valueOf(in.readString());
        rating = in.readFloat();
        esteActiv = in.readInt() == 1;
        echipa = in.createStringArray();
    }

    public static final Creator<Proiect> CREATOR = new Creator<Proiect>() {
        @Override
        public Proiect createFromParcel(Parcel in) {
            return new Proiect(in);
        }

        @Override
        public Proiect[] newArray(int size) {
            return new Proiect[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public TipProiect getTip() {
        return tip;
    }

    public void setTip(TipProiect tip) {
        this.tip = tip;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isEsteActiv() {
        return esteActiv;
    }

    public void setEsteActiv(boolean esteActiv) {
        this.esteActiv = esteActiv;
    }

    public String[] getEchipa() {
        return echipa;
    }

    public void setEchipa(String[] echipa) {
        this.echipa = echipa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nume: ").append(nume).append("\n")
                .append("Durata: ").append(durata).append(" zile\n")
                .append("Tip: ").append(tip).append("\n")
                .append("Rating: ").append(rating).append("\n")
                .append("Activ: ").append(esteActiv? "Da":"Nu").append("\n")
                .append("Echipa: ");
        if(echipa!=null && echipa.length>0) {
            for(String membru:echipa)
                sb.append(membru).append(", ");
            sb.setLength(sb.length()-2);
        } else {
                sb.append("Nu exista membrii!");
        }
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeInt(durata);
        dest.writeString(tip.name());
        dest.writeFloat(rating);
        dest.writeInt(esteActiv ? 1 : 0);
        dest.writeStringArray(echipa);
    }
}
