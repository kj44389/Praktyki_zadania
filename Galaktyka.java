public class Galaktyka {
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isGoodCharacter(String str){
        if(str.equals("N")) return true;
        else if(str.equals("W")) return true;
        else if(str.equals("S")) return true;
        else if(str.equals("E")) return true;
        else return false;
    }
    public static String[][] fillArray(String[][] str, int w, int s){
        for(int i =0;i<w;i++){
            for(int j=0;j<s;j++){
                str[i][j] = "*";
            }
        }
        return str;
    }
    public static void showArray(String[][] str, int w, int s){
        StringBuffer sb1 = new StringBuffer();
        for(int i =0;i<w;i++){
            for(int j=0;j<s;j++){
                sb1.append(str[i][j]);
            }
            sb1.append("\n");
        }
        System.out.print(sb1.toString());
    }
    public static int makeMove (String[][] str, int wielkosc, int opcja, int startx, int starty){
        boolean start = false;
        int kroki = 0;
        int tmp = wielkosc;
        int droga = 0;
            while(kroki<wielkosc+1){
                if (opcja == 1){//prawo
                    for(int i = 0; i<tmp; i++){
                        startx++;
                        str[starty][startx] = " ";
                        droga++;
                    }
                    if(start){
                        tmp-=1;
                    }
                    else start = true;
                    opcja = 2;
                }
                else if (opcja == 2){//dol
                    for(int i = 0; i<tmp; i++){
                        starty++;
                        str[starty][startx] = " ";
                        droga++;
                    }
                    if(start){
                        tmp-=1;
                    }
                    else start = true;
                    opcja = 3;
                }
                else if (opcja == 3){//lewo
                    for(int i = 0; i<tmp; i++){
                        startx--;
                        str[starty][startx] = " ";
                        droga++;
                    }
                    if(start){
                        tmp-=1;
                    }
                    else start = true;
                    opcja = 4;
                }
                else {//gora
                    for(int i = 0; i<tmp; i++){
                        starty--;
                        str[starty][startx] = " ";
                        droga++;
                    }
                    if(start){
                        tmp-=1;
                    }
                    else start = true;
                    opcja = 1;
                }
                kroki++;
            }
            droga++;
        return droga;
    }

    public static void main(String[] args) {
        if(args.length > 0 && args.length <= 1) {
            String string = args[0];
            String znak = string.substring(string.length() - 1);
            String liczba = string.substring(0, string.length() - 1);
            if (isNumeric(liczba)) {
                int wielkosc = Integer.parseInt(liczba);
                if (wielkosc > 0 && wielkosc <= 10000) {
                    if (isGoodCharacter(znak)) {
                        int szerokosc;
                        int wysokosc;
                        int opcja;
                        int starty;
                        int startx;
                        int droga = 0;

                        if (znak.equals("W") || znak.equals("E")) {
                            szerokosc = wielkosc + 2;
                            wysokosc = wielkosc + 3;
                        } else {
                            wysokosc = wielkosc + 2;
                            szerokosc = wielkosc + 3;
                        }
                        String[][] array = new String[wysokosc][szerokosc];
                        array = fillArray(array, wysokosc, szerokosc);
                        if (znak.equals("W")) {
                            opcja = 1;
                            starty = 1;
                            startx = 0;
                        } else if (znak.equals("N")) {
                            opcja = 2;
                            starty = 0;
                            startx = szerokosc - 2;
                        } else if (znak.equals("E")) {
                            opcja = 3;
                            starty = wysokosc - 2;
                            startx = szerokosc - 1;
                        } else {
                            opcja = 4;
                            starty = wysokosc - 1;
                            startx = 1;
                        }
                        array[starty][startx] = " ";
                        droga = makeMove(array, wielkosc, opcja, startx, starty);
                        showArray(array, wysokosc, szerokosc);
                        System.out.println(droga);

                    } else System.out.print("klops");
                } else System.out.print("klops");
            } else System.out.print("klops");
        } else System.out.print("klops");
        System.exit(0);
    }
}
