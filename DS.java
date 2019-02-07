package ds;
import static ds.DS.Palindromo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
public class DS {   
    
    public static void CountWords(String sTexto[]){   
    ArrayList<String> palindromos = new ArrayList<>();
    ArrayList<String> initialT = new ArrayList<>();
    ArrayList<String> fiveChars = new ArrayList<>();

        for (int i = 0; i < sTexto.length; ++i) {
            String word = sTexto[i];
            if(Palindromo(word)== true){
              palindromos.add(sTexto[i]); 
            }
            if(DeleteT(word)== false){
              initialT.add(sTexto[i]);
            }
            if(CountChars(word)== true){
              fiveChars.add(sTexto[i]);
            }
        }
    ArrayListToString(palindromos , "Palindromos");
    ArrayListToString(initialT , "LetraT");
    ArrayListToString(fiveChars, "CincoLetras");  
    }
    
    public static void Tokeneiser(String sTexto){    
        StringTokenizer stPalabras = new StringTokenizer(sTexto);
        while (stPalabras.hasMoreTokens()) {
            String sPalabra = stPalabras.nextToken(); 
            CreateFile(sPalabra + "\n" , "SinFiltro");
            System.out.println(sPalabra); 
        }
    }
    
    public static boolean CountChars(String sTexto){
        if(sTexto.length()==5){
            return true;
        }
        return false;
    }
    
    public static boolean Palindromo(String sTexto){       
    int inc = 0;
    int des = sTexto.length()-1;
    boolean bError = false;           
    while ((inc<des) && (!bError)){
	if (sTexto.charAt(inc)==sTexto.charAt(des)){				
		inc++;
		des--;
	} else {
		bError = true;
	}
        if (!bError){
            return true;
        }
        else
            return false;
    }
         return false;
    }
    
    public static boolean DeleteT(String sTexto){
        if("t".equals(sTexto.substring(0,1))){
           return false;
        }else{
           return true;
        }
    }
    
public static void CreateFile(String content, String name){  
    BufferedWriter bw = null;
    FileWriter fw = null;
    try {        
        File file = new File("/home/invitado/Escritorio/" + name);     
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(content);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
                       
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
}

public static void ArrayListToString(ArrayList<String> filtre, String name){
    String result = String.join(" ", filtre);
    CreateFile(result + " " , name);
}

public static void main(String[] args) throws IOException {
        String cadena;
        FileReader f = new FileReader(("/home/invitado/Escritorio/papita"));
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
            Tokeneiser(cadena);
            String[] parts = cadena.split(" ");
            CountWords(parts);
        }
        b.close();
    }
}
