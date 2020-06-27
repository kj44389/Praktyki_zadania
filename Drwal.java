import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class Drwal {
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
	public static byte[] toByteArray(InputStream input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		copy(input, output);
		return output.toByteArray();
	}
	public static int copy(InputStream input, OutputStream output)
			throws IOException {
		long count = copyLarge(input, output);
		if (count > Integer.MAX_VALUE) {
			return -1;
		}
		return (int) count;
	}
	public static long copyLarge(InputStream input, OutputStream output)
			throws IOException {
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}

		return count;

	}

	public static void canva(String[][] str, int wysokosc, int szerokosc) throws IOException {
		int i = 0;
		int j = 0;
		byte[] bytes = toByteArray(System.in);
			int tmp = 0;
			boolean end = false;
			for(int n = 0 ; n<= bytes.length-1; n++) {
				if (bytes[n] == 13 || bytes[n] == 10) {
					tmp++;
					if (tmp == 1) {
						j = 0;
					} else if (tmp == 2) {
						if (i < wysokosc - 1) {
							i++;
							j = 0;
							tmp = 0;
							end = false;
						} else {
							break;
						}
					}
				}else {
					if(bytes[n] != 0) {
						if(j < szerokosc-1){
							str[i][j] = Character.toString((char) bytes[n]);
							j++;
						}
						else if(j <= szerokosc-1 && end == false){
							str[i][j] = Character.toString((char) bytes[n]);
							end = true;
						}
						else{
							continue;
						}
					}
					else{
						break;
					}
				}
			}

	}
	public static void fillarray(String[][] str, int wysokosc, int szerokosc){
		String a = " ";
		for(int i = 0; i < wysokosc; i++){
			for(int j = 0; j < szerokosc ; j++){
				str[i][j] = a;
			}
		}
	}
	public static boolean isNumeric(String str) {
		if (str.equals(null)) {
			return false;
		}
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	public static void wypisz(String[][] str, int wysokosc, int szerokosc){
		int i =0;
		int j =0;
		for(i = 0; i< wysokosc ; i++){
			for(j = 0; j<szerokosc; j++){
				if(str[i][j] != null)
					//System.out.println(i+"|"+j+" = "+str[i][j]);
					System.out.print(str[i][j]);
			}
			System.out.println("");
		}
	}
	public static void malowanie(String[][] str, int startx, int starty, String kolor, int wysokosc, int szerokosc){
		if(str[starty][startx].equals(" ")){
			str[starty][startx] = kolor;
			if(starty > 0 && starty <= wysokosc ) {
				if (!(str[starty - 1][startx].equals(null)) && str[starty - 1][startx].equals(" ")) { //w gore
					malowanie(str, startx, starty - 1, kolor, wysokosc, szerokosc);
				}
			}
			if(startx > 0 && startx <= szerokosc) {
				if (!(str[starty][startx - 1].equals(null)) && str[starty][startx - 1].equals(" ")) { //w lewo
					malowanie(str, startx - 1, starty, kolor, wysokosc, szerokosc);
				}
			}
			if(startx >= 0 && startx < szerokosc){
				if( !(str[starty][startx+1].equals(null)) && str[starty][startx+1].equals(" ")){ //w prawo
					malowanie(str, startx+1, starty, kolor, wysokosc, szerokosc);
				}
			}
			if(starty >= 0 && starty < wysokosc ) {
				if (!(str[starty+ 1][startx].equals(null)) && str[starty + 1][startx].equals(" ")) { //w dol
					malowanie(str, startx, starty + 1, kolor, wysokosc, szerokosc);
				}
			}
		}
	}
    public static void main(String[] args) throws IOException {
    	int maxwysokosc = 50;
    	int maxszerokosc = 50;
	    if(args.length > 0 && args.length <= 5){
	    	if(isNumeric(args[0]) && isNumeric(args[1]) && isNumeric(args[3]) && isNumeric(args[4])){
	    		int wysokosc = Integer.parseInt(args[4]);
	    		int szerokosc = Integer.parseInt(args[3]);
	    		int startx = Integer.parseInt(args[0]);
	    		int starty = Integer.parseInt(args[1]);
				if (wysokosc <= maxwysokosc && szerokosc <= maxszerokosc) {
					if (startx <= szerokosc && starty <= wysokosc) {
						if(wysokosc > 0 && szerokosc > 0 && startx > 0 && starty > 0) {
							startx -= 1;
							starty -= 1;
							String kolor = args[2];
							String[][] array = new String[wysokosc][szerokosc];
							fillarray(array, wysokosc, szerokosc);
							wypisz(array, wysokosc, szerokosc);
							canva(array,wysokosc,szerokosc);
							if (!(array[starty][startx] == null) && array[starty][startx].equals(" ")) {
								malowanie(array, startx, starty, kolor, wysokosc-1, szerokosc-1);
								wypisz(array, wysokosc, szerokosc);
							} else System.out.println("klops");
						} else System.out.println("klops");
					} else System.out.println("klops");
				} else System.out.println("klops");
			} else System.out.println("klops");
        }else System.out.println("klops");
	    System.exit(0);
    }
}
