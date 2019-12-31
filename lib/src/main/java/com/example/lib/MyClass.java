package com.example.lib;

import javax.swing.JOptionPane;

public class MyClass {

    public static void main(String[] args){    //程式開始

        int totalA=0;

        int totalB=0;

        String title="Welcome!";

        int start=JOptionPane.showConfirmDialog(null, "歡迎來玩猜數字！", title, JOptionPane.YES_NO_OPTION);   //Google到這個語法，可以出現確認視窗

        if(start==JOptionPane.NO_OPTION){

            System.exit(0);

        }



        int a1 = (int)(Math.random()*9+1);         //產生亂數的api是Math.random(), *9因為有9個數字可猜, 加1因為讓所有數字落在1~9之間

        int b1 = (int)(Math.random()*9+1);        //我定義電腦產生的三位數分別是a1, b1, c1

        for (;a1==b1;){                                    //如果a1跟b1一樣，

            b1=(int)(Math.random()*9+1);               //那就再產生一次b1

        }



        int c1 = (int)(Math.random()*9+1);

        for (;c1==b1||c1==a1; ){                    //同上，這一段是老師課堂上教的

            c1 = (int)(Math.random()*9+1);

        }

        System.out.print(a1);

        System.out.print(b1);

        System.out.println(c1);



        guess:                            //這裡放guess因為google到這樣後面才能用continue來呼叫，重複跑

        for(;totalA!=3;){             //當所有的A還不等於3的時候(就是還沒完全猜對的時候)，就跑以下的程式

            String a2 = JOptionPane.showInputDialog("請猜第一位數");  //我定義玩家輸入的三位數字分別為a2, b2, c2

            String b2 = JOptionPane.showInputDialog("請猜第二位數");

            String c2 = JOptionPane.showInputDialog("請猜第三位數");   //三位數字分開輸入，這個是大家反應最大的問題：太麻煩了，偏偏我還不知道怎麼一次比對三個數字

            String q = a2+b2+c2;



            int usera2 = Integer.parseInt(a2);

            int userb2 = Integer.parseInt(b2);

            int userc2 = Integer.parseInt(c2);

            System.out.println("your 1st guess= "+q);

            if (usera2==a1){                           //開始比對了 a2若跟a1一樣，TotalA自動加1

                totalA = totalA+1;

            } else if(usera2==b1||usera2==c1){  //否則如果a2跟b1或c1一樣，TotalB自動加1。這裡用"||或"應該是OK的，因為數字不重複最多只會有1B

                totalB = totalB+1;

            }



            if (userb2==b1){               //同上

                totalA = totalA+1;

            } else if(userb2==a1||userb2==c1){

                totalB = totalB+1;

            }



            if (userc2==c1){

                totalA = totalA+1;

            } else if(userc2==a1||userc2==b1){

                totalB = totalB+1;

            }

            System.out.println("Result "+totalA+"A"+totalB+"B");          //每猜完一次就秀出結果是幾A幾B

            JOptionPane.showConfirmDialog(null, "Result "+totalA+"A"+totalB+"B", title, JOptionPane.YES_NO_OPTION);

            if (totalA==3){                      //當totalA等於3，代表全猜中了，就跑下面的確認視窗

                JOptionPane.showConfirmDialog(null, "猜中了！再玩一次？", title, JOptionPane.YES_NO_OPTION);

                System.exit(0);         //確認完後自動結束程式

            }

            totalA=0;               //每猜完一次後，將計數器歸零 放在這邊好像有點怪，但的確是可以用

            totalB=0;

            continue guess;   //重新跑一次guess



        }

    }

}