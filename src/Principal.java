import java.io.IOException;
import java.util.Scanner;

public class Principal  {

    public static Scanner scanner = new Scanner(System.in);
        public static void main (String [] args) throws IOException, InterruptedException {

            String menu = """
                    Conversor de divisas
                  
                  1-Imprimir el listado de coeficientes de las monedas respecto al Dolar Estadounidense.
                  2-Cambiar Pesos Colombianos a Dolares Estadounidenses.
                  3-Cambiar Dolares Estadounidenses a Pesos Colombianos.
                  4-Cambiar Pesos Colombianos a Euros.
                  5-Cambiar Euros a Pesos Colombianos.
                  6-Cambiar Pesos Colombianos a Reales Brasileños.
                  7-Cambiar Reales Brasileños a Pesos Colombianos.
                  8-Salir.
                  """;
            int opcion;
            int seguir;
            do {
                System.out.println(menu);
                System.out.println("Elige el cambio de moneda que quieres realizar");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        Lista lista = new Lista();
                        lista.imprimirLista();

                        System.out.println("Desea realizar otra operación? ");
                        System.out.println("1-si");
                        System.out.println("2-no");
                        seguir = scanner.nextInt();
                        if (seguir == 1) {
                            break;
                        } else {
                            opcion = 8;
                            break;
                        }
                    case 2:
                        convertir("COP", "USD", scanner);
                        System.out.println("Desea realizar otra operación? ");
                        System.out.println("1-si");
                        System.out.println("2-no");
                        seguir = scanner.nextInt();
                        if (seguir == 1) {
                            break;
                        } else {
                            opcion = 8;
                            break;
                        }
                    case 3:
                        convertir("USD", "COP", scanner);
                        System.out.println("Desea realizar otra operación? ");
                        System.out.println("1-si");
                        System.out.println("2-no");
                        seguir = scanner.nextInt();
                        if (seguir == 1) {
                            break;
                        } else {
                            opcion = 8;
                            break;
                        }
                    case 4:
                        convertir("COP", "EUR", scanner);
                        System.out.println("Desea realizar otra operación? ");
                        System.out.println("1-si");
                        System.out.println("2-no");
                        seguir = scanner.nextInt();
                        if (seguir == 1) {
                            break;
                        } else {
                            opcion = 8;
                            break;
                        }
                    case 5:
                        convertir("EUR", "COP", scanner);
                        System.out.println("Desea realizar otra operación? ");
                        System.out.println("1-si");
                        System.out.println("2-no");
                        seguir = scanner.nextInt();
                        if (seguir == 1) {
                            break;
                        } else {
                            opcion = 8;
                            break;
                        }
                    case 6:
                        convertir("COP", "BRS", scanner);
                        System.out.println("Desea realizar otra operación? ");
                        System.out.println("1-si");
                        System.out.println("2-no");
                        seguir = scanner.nextInt();
                        if (seguir == 1) {
                            break;
                        } else {
                            opcion = 8;
                            break;
                        }
                    case 7:
                        convertir("BRL", "COP", scanner);
                        System.out.println("Desea realizar otra operación? ");
                        System.out.println("1-si");
                        System.out.println("2-no");
                        seguir = scanner.nextInt();
                        if (seguir == 1) {
                            break;
                        } else {
                            opcion = 8;
                            break;
                        }
                    case 8:

                        System.out.println(" ");
                        System.out.println("Fin del programa.");
                        System.out.println(" ");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 8);

            System.out.println(" ");
            System.out.println("Gracias por usar nuestros servicios.");
            System.out.println("\uD83D\uDE80");

            scanner.close();
        }
            private static void convertir(String Moneda, String monedaDeDestino, Scanner scanner) throws IOException, InterruptedException {
                System.out.println("Ingresa el monto que quieras convertir: ");
                double montoAConvertir = scanner.nextDouble();
                ConsultaMoneda conversion = new ConsultaMoneda(Moneda, monedaDeDestino, montoAConvertir);
            try {
                double result = conversion.convert();
                System.out.println(montoAConvertir + Moneda + " Son " + result + "" + monedaDeDestino);
                System.out.println("");
                System.out.println("Operacion exitosa.");
                System.out.println("");
            } catch (IOException | InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
        }
    }
 /* USD: Dólar estadounidense
AED: Dirham de los Emiratos Árabes Unidos
AFN: Afghani afgano
ALL: Lek albanés
AMD: Dram armenio
ANG: Florín antillano neerlandés
AOA: Kwanza angoleño
ARS: Peso argentino
AUD: Dólar australiano
AWG: Florín arubeño
AZN: Manat azerbaiyano
BAM: Marco convertible de Bosnia-Herzegovina
BBD: Dólar de Barbados
BDT: Taka de Bangladesh
BGN: Lev búlgaro
BHD: Dinar bareiní
BIF: Franco burundés
BMD: Dólar de Bermudas
BND: Dólar de Brunei
BOB: Boliviano boliviano
BRL: Real brasileño
BSD: Dólar de las Bahamas
BTN: Ngultrum butanés
BWP: Pula de Botsuana
BYN: Rublo bielorruso
BZD: Dólar beliceño
CAD: Dólar canadiense
CDF: Franco congoleño
CHF: Franco suizo
CLP: Peso chileno
CNY: Yuan chino
COP: Peso colombiano
CRC: Colón costarricense
CUP: Peso cubano
CVE: Escudo caboverdiano
CZK: Corona checa
DJF: Franco yibutiano
DKK: Corona danesa
DOP: Peso dominicano
DZD: Dinar argelino
EGP: Libra egipcia
ERN: Nakfa eritreo
ETB: Birr etíope
EUR: Euro
FJD: Dólar fiyiano
FKP: Libra de las Islas Malvinas
FOK: Corona faroense
GBP: Libra esterlina
GEL: Lari georgiano
GGP: Libra de Guernsey
GHS: Cedi ghanés
GIP: Libra de Gibraltar
GMD: Dalasi gambiano
GNF: Franco guineano
GTQ: Quetzal guatemalteco
GYD: Dólar guyanés
HKD: Dólar de Hong Kong
HNL: Lempira hondureño
HRK: Kuna croata
HTG: Gourde haitiano
HUF: Florín húngaro
IDR: Rupia indonesia
ILS: Shekel israelí
IMP: Libra de la Isla de Man
INR: Rupia india
IQD: Dinar iraquí
IRR: Rial iraní
ISK: Corona islandesa
JEP: Libra de Jersey
JMD: Dólar jamaicano
JOD: Dinar jordano
JPY: Yen japonés
KES: Chelín keniano
KGS: Som kirguís
KHR: Riel camboyano
KID: Dólar de Kiribati
KMF: Franco comorense
KRW: Won surcoreano
KWD: Dinar kuwaití
KYD: Dólar de las Islas Caimán
KZT: Tenge kazajo
LAK: Kip laosiano
LBP: Libra libanesa
LKR: Rupia de Sri Lanka
LRD: Dólar liberiano
LSL: Loti de Lesoto
LYD: Dinar libio
MAD: Dirham marroquí
MDL: Leu moldavo
MGA: Ariary malgache
MKD: Denar macedonio
MMK: Kyat birmano
MNT: Tugrik mongol
MOP: Pataca de Macao
MRU: Uguia mauritana
MUR: Rupia mauriciana
MVR: Rufiyaa maldiva
MWK: Kwacha malauí
MXN: Peso mexicano
MYR: Ringgit malasio
MZN: Metical mozambiqueño
NAD: Dólar namibio
NGN: Naira nigeriana
NIO: Córdoba nicaragüense
NOK: Corona noruega
NPR: Rupia nepalí
NZD: Dólar neozelandés
OMR: Rial omaní
PAB: Balboa panameño
PEN: Sol peruano
PGK: Kina papuana
PHP: Peso filipino
PKR: Rupia paquistaní
PLN: Zloty polaco
PYG: Guaraní paraguayo
QAR: Riyal qatarí
RON: Leu rumano
RSD: Dinar serbio
RUB: Rublo ruso
RWF: Franco ruandés
SAR: Riyal saudí
SBD: Dólar de las Islas Salomón
SCR: Rupia seychelense
SDG: Libra sudanesa
SEK: Corona sueca
SGD: Dólar de Singapur
SHP: Libra de Santa Elena
SLE: Leone sierraleonés
SLL: Leone sierraleonés
SOS: Chelín somalí
SRD: Dólar surinamés
SSP: Libra sursudanesa
STN: Dobra santotomense
SYP: Libra siria
SZL: Lilangeni suazi
THB: Baht tailandés
TJS: Somoni tayiko
TMT: Manat turcomano
TND: Dinar tunecino
TOP: Pa'anga tongano
TRY: Lira turca
TTD: Dólar de Trinidad y Tobago
TVD: Dólar de Tuvalu
TWD: Nuevo dólar taiwanés
TZS: Chelín tanzano
UAH: Grivna ucraniana
UGX: Chelín ugandés
UYU: Peso uruguayo
UZS: Som uzbeko
VES: Bolívar venezolano
VND: Dong vietnamita
VUV: Vatu vanuatuense
WST: Tala samoano
XAF: Franco CFA de África Central
XCD: Dólar del Caribe Oriental
XDR: Derechos especiales de giro (FMI)
XOF: Franco CFA de África Occidental
XPF: Franco CFP
YER: Rial yemení
ZAR: Rand sudafricano
ZMW: Kwacha zambiano
ZWL: Dólar zimbabuense*/
