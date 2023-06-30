package utilidades;

public class Animaciones {
    public enum Jugador {
        QUIETO(1,0),
        AGACHADO(1,1),
        CAMINANDO(2,2),
        CORRIENDO(3,3),
        FRENANDO(1,4),
        NADANDO(4,5),
        SALTANDO(1,6),
        SALTANDO_CORRIENDO(1,7),
        AGARRANDO_CAMINANDO(2,8),
        TUBERIA(1,9),
        RESBALANDO(1,10),
        AGARRANDO_QUIETO(1,11),
        TREPANDO(1,12),
        TIRANDO(1,13);

        final int cantidadDeFrames;
        final int posicion;

        Jugador(int cantidadDeFrames, int posicion) {
            this.cantidadDeFrames = cantidadDeFrames;
            this.posicion = posicion;
        }

        public int getCantidadDeFrames() {
            return cantidadDeFrames;
        }

        public int getPosicion() {
            return posicion;
        }
    }
}
