package programacion.tiempo;

/**
 * La clase Time representa una hora determinada, un momento de un día. Esta
 * representación cuenta con un valor para hora, minuto y segundo.
 */
public class Time {
  /**
   * valor de hora, debe tener siempre un valor entre 0 y 23
   */
  int hora;

  /**
   * valor de minuto, debe tener siempre un valor entre 0 y 59
   */
  int minuto;

  /**
   * valor de segundo, debe tener siempre un valor entre 0 y 59
   */
  int segundo;

  boolean nextDay;

  /**
   * Constructor que inicializa los tres atributos de Hora: hora, minuto y segundo
   * 
   * @param hora    Valor inicial para hora
   * @param minuto  Valor inicial para minuto
   * @param segundo Valor inicial para segundo
   */
  public Time(int hora, int minuto, int segundo, boolean nextDay) {
    this.hora = hora;
    this.minuto = minuto;
    this.segundo = segundo;
    this.nextDay = false;
  }

  /**
   * Constructor que inicializa dos atributos de Hora: hora y minuto
   * 
   * @param hora   Valor inicial para hora
   * @param minuto Valor inicial para minuto
   */
  public Time(int hora, int minuto) {
    this.hora = hora;
    this.minuto = minuto;
  }

  public Time() {
  }
  /**
   * @return si el nextDay es true solo si ha pasado de 24 horas.
   */
  public boolean getNextDay(){
    return nextDay;
  }

  /**
   * Método que permite concatenar Strings con objetos de tipo Time. Nos permitirá
   * llamar a println() pasando una instancia de Time.
   * 
   * @return String con la representación de Time separando la hora, los minutos y
   *         los segundos con el caracter "dos puntos"
   */
  public String toString() {
    /*
      
      Modificar la forma de construir el String que devuelve el método toString para que utilize 
      2 dígitos para cada campo: hora, minuto y segundo. 
      Se espera que el mediodía se represente como "12:00:00", en vez de "12:0:0", y la medianoche
      como "00:00:00" en vez de "0:0:0"

      Pista: se recomienda mirar la documentación del método String.format()
    */

    return String.format("%02d:%02d:%02d", hora, minuto, segundo);
  }

  /**
   * Añade secs segundos
   * 
   * @param secs Segundos a añadir a la instancia de Time
   * 
   * @return true si se ha podido añadir, false si el parámetro no era válido y el
   *         objeto no se ha modificado
   */
  public boolean addSeconds(int secs) {
    if(secs<0){
      return false;
    }else{
      int secsTotales = secs + segundo;
      if (secsTotales<60){
        segundo = secsTotales;
        return true;
      }else{
        if (addMinutes(secsTotales/60)){
          segundo = secsTotales % 60;
          return true;
        }else{
          return false;
        }
      }
      
    }
    /*
     * :
     * Implementar la lógica en la que se añaden segundos. Comprobar que secs es un
     * entero mayor o igual que 0.
     * Si el resultado de añadir los segundos da un resultado mayor que 60, habrá
     * que aumentar también minuto.
     */

  }

  /**
   * Añade mins minutos
   * 
   * @param mins Minutos a añadir a la instancia de Time
   * 
   * @return true si se ha podido añadir, false si el parámetro no era válido y el
   *         objeto no se ha modificado
   */
  public boolean addMinutes(int mins) {
    if(mins<0){
      return false;
    }else{
      int minsTotales = mins + minuto;
      if (minsTotales<60){
        minuto = minsTotales;
        return true;
      }else{
        if (addHoras(minsTotales/60)){
          minuto = minsTotales % 60;
          return true;
        }else{
          return false;
        }
      }
      /*
      *:
      * Implementar la lógica en la que se añaden minutos. Comprobar que mins es un
      * entero mayor o igual que 0.
      * Si el resultado de añadir los minutos da un resultado mayor que 60, habrá que
      * aumentar también hora.
      */
    }
  }

  /**
   * Añade hours horas
   * 
   * @param hours Horas a añadir a la instancia de Time
   * 
   * @return true si se ha podido añadir, false si el parámetro no era válido y el
   *         objeto no se ha modificado
   */
  public boolean addHoras(int hours) {
    if(hours<0){
      return false;
    }else{
      int hoursTotales = hours + hora;
      if (hoursTotales<24){
        hora = hoursTotales;
        return true;
      }else{
        if (hoursTotales/24 > 0){
          hora = hoursTotales % 24;
          nextDay = true;
          return true;
        }else{
          return false;
              }
            }
          /*
          *
          * Implementar la lógica en la que se añaden horas. Comprobar que hours es un
          * entero mayor o igual que 0.
          * Si el resultado de añadir las horas da un resultado mayor que 23, habrá que
          * dejar una hora válida.
          */
          

          }

    }
  }