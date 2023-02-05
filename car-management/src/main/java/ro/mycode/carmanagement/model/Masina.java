package ro.mycode.carmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name="Masina")
@Table(name="masini")
public class Masina implements Comparable<Masina>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String marca;
    private String model;
    private int an;
    private String culoare;


    @Override
    public int compareTo(Masina o) {
        if (this.an > o.an){
            return 1;
        }
        else if(this.an < o.an){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        Masina m = (Masina) o;
        return this.an == m.an;
    }
}
