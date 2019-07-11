package com.ceiba.dominio.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public final class ValidarTiempo {

	private ValidarTiempo() {}
	
	static final int MINUTOS_POR_HORA = 60;
    static final int SEGUNDOS_POR_MINUTOS = 60;
    static final int SEGUNDOS_POR_HORA = SEGUNDOS_POR_MINUTOS * MINUTOS_POR_HORA;

    private static long[] obtenerTiempo(LocalDateTime desde, LocalDateTime hasta) {
        LocalDateTime hoy = LocalDateTime.of(hasta.getYear(),
                hasta.getMonthValue(), hasta.getDayOfMonth(), desde.getHour(), desde.getMinute(), desde.getSecond());
        Duration duracion = Duration.between(hoy, hasta);

        long segundos = duracion.getSeconds();

        long Horas = segundos / SEGUNDOS_POR_MINUTOS;
        long minutos = ((segundos % SEGUNDOS_POR_MINUTOS) / SEGUNDOS_POR_MINUTOS);
        long segundo = (segundos % SEGUNDOS_POR_MINUTOS);

        return new long[]{Horas, minutos, segundo};
    }
	
}
