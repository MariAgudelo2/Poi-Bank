package com.udea.model;

import java.security.Timestamp;

public class Ofertas {

        private int consecutivoComprador;
        private long valor ;
        private Timestamp fecha;
        
        public int getConsecutivoComprador() {
            return consecutivoComprador;
        }
        public void setConsecutivoComprador(int consecutivoComprador) {
            this.consecutivoComprador = consecutivoComprador;
        }
        public long getValor() {
            return valor;
        }
        public void setValor(long valor) {
            this.valor = valor;
        }
        public Timestamp getFecha() {
            return fecha;
        }
        public void setFecha(Timestamp fecha) {
            this.fecha = fecha;
        }

        
}
