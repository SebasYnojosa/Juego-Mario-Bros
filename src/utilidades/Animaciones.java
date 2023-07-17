package utilidades;

public class Animaciones {
    public enum Jugador {
        QUIETO(1),
        AGACHADO(1),
        CAMINANDO(2),
        CORRIENDO(3),
        FRENANDO(1),
        NADANDO(4),
        SALTANDO(1),
        SALTANDO_CORRIENDO(1),
        AGARRANDO_CAMINANDO(2),
        TUBERIA(1),
        RESBALANDO(1),
        AGARRANDO_QUIETO(1),
        TREPANDO(1),
        TIRANDO(1);

        final int cantidadDeFrames;

        Jugador(int cantidadDeFrames) {
            this.cantidadDeFrames = cantidadDeFrames;
        }

        public int getCantidadDeFrames() {
            return cantidadDeFrames;
        }

        public int getPosicion() {
            return ordinal();
        }
    }

    public enum Enemigo {
        CAMINANDO(2),
        MURIENDO(1),
        CAPARAZON(1),
        CAPARAZON_GIRO(3),
        VOLANDO(2);
        final int cantidadDeFrames;

        Enemigo(int cantidadDeFrames) {
            this.cantidadDeFrames = cantidadDeFrames;
        }

        public int getCantidadDeFrames() {
            return cantidadDeFrames;
        }



        public int getPosicion() {
            return ordinal();
        }
    }
}
