package coursera;

import java.util.Scanner;

/**
 * 熄灯问题
 */
public class TurnOffLight {

    public static int[][] puzzle=new int[6][8];
    public static int[][] press=new int[6][8];
    //枚举第一行的64种情况
    public static void enumerate(){
        int c;
        //初始化press第一行为0
//        for (c=1;c<7;c++){
//            press[1][c]=0;
//        }
        while (guess()==false){
            press[1][1]++;
            c=1;
            while (press[1][c]>1){
                press[1][c]=0;
                c++;
                press[1][c]++;
            }
        }
        return;
    }

    public static boolean guess(){
        int c,r;
        //根据puzzle的状态以及枚举press第一行情况计算press的2-5行
        for (r=1;r<5;r++){
            for (c=1;c<7;c++){
                press[r+1][c]=(puzzle[r][c]+press[r][c]+press[r-1][c]+press[r][c-1]+press[r][c+1])%2;
            }
        }
        for (c=1;c<7;c++){
            if((press[5][c-1]+press[5][c]+press[5][c+1]+press[4][c])%2!=puzzle[5][c])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        //init
//        for(int c=0;c<8;c++){
//            puzzle[0][c]=press[0][c]=0;
//        }
//        for (int r=0;r<6;r++){
//            puzzle[r][0]=puzzle[r][7]=press[r][0]=press[r][7]=0;
//        }
        //input
        Scanner cin = new Scanner(System.in);
        for (int r=1;r<6;r++){
            for (int c=1;c<7;c++){
                puzzle[r][c]=cin.nextInt();
            }
//            String[] num=cin.nextLine().split(" ");
//            for(int c=1;c<num.length;c++){
//                puzzle[r][c]= Integer.parseInt(num[c-1]);
//            }
        }
        enumerate();
        for (int r=1;r<6;r++){
            for(int c=1;c<7;c++){
                System.out.print(press[r][c]+" ");
            }
            System.out.println("");
        }
    }
}
