public class Kosmolot {
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
    ///dla N
    public static String makeSpaces(String str, int n){
        for(int i = 0 ; i< n; i++){
            str += " ";
        }
        return str;
    }
    public static String makeStars(String str, int n){
        for(int i = 0 ; i< n; i++){
            str += "*";
        }
        return str;
    }
    ///dla Y
    public static String startl(String str, int n, boolean x){
        str+=">";
        if(x == true) {
            for(int i =1; i <=n-1 ;i++) {
                str+="\\";
            }
        }
        else {
            for(int i =1; i <=n-1 ;i++) {
                str+="*";
            }
        }
        return str;
    }
    public static String startp(String str, int n) {
        str+=">";
        for(int i =1; i <=n-1 ;i++) {
            str+="/";
        }
        return str;
    }
    public static String makeSBegin(String str, int n){

        return str;}
    public static String makeStep(String str, int n, boolean nomiddle, boolean end, boolean right){
        if(right==false) {
            if (nomiddle == true) {
                for (int i = 1; i <= n - 1; i++) {
                    str += "*";
                }
                str += "\\";
            } else {
                if (end == false) {
                    for (int i = 1; i <= n; i++) {
                        str += "*";
                    }
                } else {
                    for (int i = 1; i <= n - 1; i++) {
                        str += "*";
                    }
                    str += ">";
                }

            }
        }
        else{
            if (nomiddle == true) {
                for (int i = 1; i <= n - 1; i++) {
                    str += "*";
                }
                str += "/";
            } else {
                if (end == false) {
                    for (int i = 1; i <= n; i++) {
                        str += "*";
                    }
                } else {
                    for (int i = 1; i <= n - 1; i++) {
                        str += "*";
                    }
                    str += ">";
                }

            }
        }
        return str;}
    public static void main(String[] args) {
        String pancerz = args[1];


	    if(args.length > 0 && args.length == 2){ // Czy 2 argumenty?
	        if(isNumeric(args[0])){ // jest intem?
	            int rozmiar = Integer.parseInt(args[0]);
                String[] lanes = new String[rozmiar*2];
                for (int i = 0; i <= rozmiar*2-1; i++) lanes[i] = "";
	            if(rozmiar >= 1 && rozmiar <= 75){ // rozmiar sie zgadza?
                    if(pancerz.equals("N") || pancerz.equals("Y")){ // Czy N lub Y?
                        if(pancerz.equals("N")){
                            if(rozmiar == 1){
                                System.out.println("*");
                            }
                            else {
                                for (int i = 1; i <= rozmiar; i++) {

                                    for(int j = 1; j <= rozmiar; j++){
                                        lanes[j-1] = makeStars(lanes[j-1], j);
                                        lanes[j-1] = makeSpaces(lanes[j-1], rozmiar-j);
                                    }
                                    for(int j = 1; j <= rozmiar; j++){
                                        lanes[rozmiar+j-1] = makeStars(lanes[rozmiar+j-1], rozmiar-j);
                                        lanes[rozmiar+j-1] = makeSpaces(lanes[rozmiar+j-1], j);
                                    }
                                }

                                for (int i = 0; i <= rozmiar*2-1; i++) {
                                    System.out.println(lanes[i]);
                                }
                            }
                        }
                        else { ////dla Y
                            if (rozmiar == 1) {
                                System.out.println(">");
                            } else {
                                for (int i = 1; i <= rozmiar; i++) {
                                    if (i == 1) {
                                        for (int j = 1; j <= rozmiar; j++) {
                                            if (j != rozmiar) lanes[j - 1] = startl(lanes[j - 1], j, true);
                                            else lanes[j - 1] = startl(lanes[j - 1], j, false);
                                            lanes[j - 1] = makeSpaces(lanes[j - 1], rozmiar - j);
                                        }
                                        for(int j = 1; j <= rozmiar-1; j++){
                                            lanes[rozmiar+j-1] = startp(lanes[rozmiar+j-1], rozmiar-j);
                                            lanes[rozmiar+j-1] = makeSpaces(lanes[rozmiar+j-1], j);
                                        }

                                    } else {
                                        for (int j = 1; j <= rozmiar; j++) {
                                            if (j != rozmiar) lanes[j - 1] = makeStep(lanes[j - 1], j, true, false, false);
                                            else{
                                                if(i != rozmiar) lanes[j - 1] = makeStep(lanes[j - 1], j, false,false, false);
                                                else lanes[j - 1] = makeStep(lanes[j - 1], j, false,true, false);
                                            }
                                            lanes[j - 1] = makeSpaces(lanes[j - 1], rozmiar - j);
                                        }

                                        for(int j = 1; j <= rozmiar-1; j++){
                                            lanes[rozmiar*2-j - 1] = makeStep(lanes[rozmiar*2-j - 1], j, true, false, true);
                                            lanes[rozmiar*2-j - 1] = makeSpaces(lanes[rozmiar*2-j - 1], rozmiar - j);
                                        }
                                    }
                                }

                                for (int i = 0; i <= rozmiar * 2 - 1; i++) {
                                    System.out.println(lanes[i]);
                                }
                            }
                        }

                    }
                    else System.out.print("klops");
                }
	            else System.out.print("klops");
            }
	        else System.out.print("klops");
        }
	    else System.out.print("klops");
        System.exit(0);
    }
}
