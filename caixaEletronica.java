import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class caixaEletronica {
	
	public static void main(String[] args) {
	
		Scanner d = new Scanner (System.in);
	
		double sacar;
		int quantidade = 0;
	
		try {
			System.out.println("Digite o valor que deseja sacar: ");
			sacar = d.nextDouble();
			
			 System.out.printf("%s", calculaSaque(sacar, quantidade));
			 
		} 
		catch (InputMismatchException e){
			 System.err.printf("\nErro: Operação invalida!!");
		}
      }
	
	public static String calculaSaque(double sacar, int quantidade) {
		DecimalFormat formatador = new DecimalFormat("##,##0.00");
		if (sacar <=0 ) {
			return("Insira um valor maior ou igual a um" + "\n");
		}
		else {
		  int nota [] = {200,100,50,20,10,5,2,1};
		  int moedas [] = {50,25,10,5};
		  
		  String result;
		  double saque;
		  int i, vlr, ct;
		  
		  saque = sacar - quantidade;
		  result = "Saque = R$" + formatador.format(saque) + "\n";
		  
		  vlr = (int) saque;
		  i = 0;
		  while(vlr != 0) {
			ct = vlr/ nota[i];
			if (ct !=0) {
				result = result + (ct + "notas(s)" + nota[i] + "\n");
				vlr = vlr % nota[i];
			}
			i = i +1;
		  }
		  result = result + "\n";
		  
		  
		  vlr = (int)Math.round((saque - (int)saque)*100);
		  i = 0;
		  while(vlr!=0) {
			  ct = vlr/moedas[i];
			  if (ct !=0) {
				  result = result + (ct + "moeda(s)" + moedas[i] + "\n");
				  vlr = vlr % moedas [i];
				}
			  i = i +1;
			 }
		  return(result);
		}
		
		
	}
}



