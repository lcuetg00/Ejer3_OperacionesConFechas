import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fecha1;
        String fecha2;

        //Formato por defecto de LocalDate YYYY-MM-DD
        try {
            System.out.println("Formato para las fechas: YYYY-MM-DD");
            System.out.println("Inserte la primera fecha");
            fecha1 = scanner.next();
            System.out.println("Inserte la segunda fecha");
            fecha2 = scanner.next();

            LocalDate primeraFecha = LocalDate.parse(fecha1);
            LocalDate segundaFecha = LocalDate.parse(fecha2);

            //Diferencia de días entre las 2 fechas
            long diasEntreFechas = ChronoUnit.DAYS.between(segundaFecha, primeraFecha);
            System.out.println("La diferencia entre las dos fechas es de "+diasEntreFechas+" días.");

            //Inicio de año
            TemporalAdjuster ajustadorInicioAnyo = TemporalAdjusters.firstDayOfYear();
            TemporalAdjuster ajustadorFinalAnyo = TemporalAdjusters.lastDayOfYear();

            LocalDate inicioAnyo1 = primeraFecha.with(ajustadorInicioAnyo);
            LocalDate inicioAnyo2 = segundaFecha.with(ajustadorInicioAnyo);
            LocalDate finalAnyo1 = primeraFecha.with(ajustadorFinalAnyo);
            LocalDate finalAnyo2 = segundaFecha.with(ajustadorFinalAnyo);

            System.out.println("Para la primera fecha:");
            System.out.println("La fecha inicial del año es: " + inicioAnyo1.toString() + " y la final es: "+finalAnyo1.toString());
            System.out.println("El año tiene "+ primeraFecha.lengthOfYear() + " días.");
            System.out.println("El día de la semana de la fecha es " + devolverStringDiaSemana(primeraFecha.getDayOfWeek()));
            System.out.println();
            System.out.println("Para la segunda fecha:");
            System.out.println("La fecha inicial del año es: " + inicioAnyo2.toString() + " y la final es: " + finalAnyo2.toString());
            System.out.println("El año tiene "+ segundaFecha.lengthOfYear() + " días.");
            System.out.println("El día de la semana de la fecha es " + devolverStringDiaSemana(segundaFecha.getDayOfWeek()));


        } catch(DateTimeParseException e) {
            System.out.println("Ha escrito una fecha no válida. Revise el formato de la fecha\nAsegurese de que el mes está comprendido entre el 1 y el 12, y de que el día es uno de los posibles días del mes.");

        } catch(Exception e) {
            System.out.println(e.toString());
        }





    }

    /**
     * Para un determinado DayOfWeek (MONDAY, TUESDAY,..) devuelve su traducción al español en forma de String
     * @param diaSemana
     * @return String con el día de la semana en español.
     * @throws NullPointerException si diaSemana es null
     */
    public static String devolverStringDiaSemana(DayOfWeek diaSemana) throws  NullPointerException{
        if(diaSemana == null) {
            throw new NullPointerException("Método devolverStringDiaSemana: parámetro argumentado es igual a null");
        }
        String stringDia = "";
        switch(diaSemana) {
            case MONDAY: stringDia="lunes";
                         break;
            case TUESDAY: stringDia="martes";
                break;
            case WEDNESDAY: stringDia="miércoles";
                break;
            case THURSDAY: stringDia="jueves";
                break;
            case FRIDAY: stringDia="viernes";
                break;
            case SATURDAY: stringDia="sábedo";
                break;
            case SUNDAY: stringDia="domingo";
                break;
        }
        return  stringDia;
    }





}