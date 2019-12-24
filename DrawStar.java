public class DrawStar{
    public static void main(String[] args) {
	
          	for (int a = 2; a<= 100; a++){
		boolean c = true;
            		for (int b = 2; b<=100;b++){
              			if (a%b==0 && a!=b){
				c = false;
                				System.out.println(a+"不是素数");
               			 	break;
             			 }
            		}
           		 if (c == true){
              			System.out.println(a+"是素数");
            		}
          	}
            }
}
