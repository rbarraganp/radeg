package com.rbp.radeg.dto;

import java.sql.Timestamp;

public class WeightDto {


        //ATTRIBUTES
        private long idWeight;
        private double weight;

        private Timestamp date;

        //RELATIONS

        //*** USER ***
        private Long idUser;


        //BUILDER
        public WeightDto() {}


        //GETTER AND SETTER
        public long getIdWeight() { return idWeight;}
        public void setIdWeight(long idWeight) { this.idWeight = idWeight;}

        public double getWeight() { return weight;}
        public void setWeight(double weight) { this.weight = weight;}

        public Long getIdUser() { return idUser;}
        public void setIdUser(Long idUser) { this.idUser = idUser;}

        public Timestamp getDate() { return date; }
        public void setDate(Timestamp date) { this.date = date;}
}
