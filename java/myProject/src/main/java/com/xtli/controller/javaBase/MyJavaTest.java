package com.xtli.controller.javaBase;

import java.io.IOException;

import org.springframework.util.StringUtils;

/** 使用循环输出久久乘法表
 *  1*1=1
 *  2*1=2,2*2=4
 *  ....
 *  9*1=9,9*2=18,...9*9=81
 *//*
public class MyJavaTest {
	public static void main(String[] args) {
		for(int i = 1 ; i <= 9 ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				int k = i * j;
				System.out.print(i + " * "+ j + " = "+ k);
				if(j <= i-1) {
					System.out.print(" , ");
				}
			}
			System.out.println("");
		}
	}
}*/
/* 输出等腰三角形
 * 		*
 * 	   ***
 * 	  *****
 * 	 *******
 */
/*public class MyJavaTest {
	public static void main(String[] args) {
		if(args.length <= 0) {
			System.out.println("请输入行数");
			return;
		}
		
		int num = Integer.valueOf(args[0]);
		printTriangle(num);
	}
	private static void printTriangle(int num) {
		int td = 2 * num - 1;//控制输出最多的列数
		for(int i = 1 ; i <= num ; i++){//控制输出的行数
			for(int j = 1 ; j <= td ; j++) {
				if(j == num - i + 1) {//判断每行从哪列开始输出*
					for(int k = 1 ; k<=2*i-1 ; k++) {//控制开始输出时，输出*个数
						System.out.print("*");
					}
					System.out.println("");//输出完换行
					break;//结束列的输出，开始下一行
				} else {//开始输出*之前，输出空串“ ”
					System.out.print(" ");
				}
			}
		}
	}
}*/
/*
 * 画圆
 * 效果:
 * 			**
 * 		*		 *
 * 	  *			   *
 *   *				*
 *   *				*
 *    *			   *
 *    	*		*
 *    		**
 */
public class MyJavaTest {
	public static void main(String[] args) {
		if(args.length <= 0) {
			System.out.println("请输入行数");
			return;
		}
		
		int num = Integer.valueOf(args[0]);
		printCircle(num);
	}
	
	private static void printCircle(int num) {
		int xy = 2 * num;//画圆区域的边长。
		int radius = num;//半径
		//每行循环，找出和圆心距离最接近半径的坐标并输出*（以圆心纵向分界，左右各一个*）
		for(int i = 0 ; i <= xy ; i++) {
			//计算第i行，左半边最接近半径的点
			int yLeftColumn = findDotEqualRadius(i,0,num,radius);
			for(int j = 0; j <= num; j++) {
				if( j == yLeftColumn) {
					System.out.print("*");
				}
				System.out.print(" ");
			}
			//计算第i行，右半边最接近半径的点
			int yRightColumn = findDotEqualRadius(i,num,xy,radius);
			for(int j = num+1; j <= xy; j++) {
				if( j == yRightColumn) {
					System.out.print("*");
				}
				System.out.print(" ");
			}
			System.out.println("");
		}
		
	}
	/*
	 * 计算任意两点间的距离
	 */
	private static double computeDistance(int[] firDot, int[] secDot) {
		double xLine = firDot[0] - secDot[0];//横向坐标
		double yLine = firDot[1] - secDot[1];//纵向坐标
		return Math.sqrt(xLine * xLine + yLine * yLine);
	}
	/*
	 * 找出某行中距离最接近半径的一点，返回此点的列坐标。
	 * i为行号，leftBorder和rightBorder为列边界值,radius为半径。即在i行，[leftBorder,rightBorder]中寻找
	 */
	private static int findDotEqualRadius(int i, int leftBorder, int rightBorder, int radius) {
		int[] circleHeart = new int[]{radius,radius};//圆心坐标
		double distance = 0.0d;
		int equalColumn = leftBorder;//记录最优点列坐标,默认最左边点
		int[] leftLocation = new int[]{i,leftBorder};
		//最左边点与圆心的距离
		distance = computeDistance(leftLocation, circleHeart); 
		double radiusError = Math.abs(distance - radius);//最左边点的起始误差
		for(int k = leftBorder; k <= rightBorder ; k++) {
			int[] temp = new int[]{i,k};//第i行，第k列坐标
			distance = computeDistance(temp, circleHeart);//与圆心距离
			double radiusErrorTemp = Math.abs(distance - radius);
			if(radiusErrorTemp < radiusError) {//若当前误差小于最优误差，则记录下当前列及误差值；
				equalColumn = k;
				radiusError = radiusErrorTemp;
			}
		}
		return equalColumn;
	}
}


/*
 * 以上代码画出来的是左右短，上下长的椭圆。这是因为横向一个单位与纵向的一个单元长短不同。（纵向一个单位长度大致是横向单位的2倍）
 * 为了让图形更圆，将宽定义为4倍半径，长仍为2倍半径
 *
 

	private static void printCircleVersion2(int num) {
		//int xy = 2 * num;//画圆区域的边长。
		int width = 4 * num;//宽
		int length = 2 * num;//长
		int radius = num;//半径
		//每行循环，找出和圆心距离最接近半径的坐标并输出*（以圆心纵向分界，左右各一个*）
		for(int i = 0 ; i <= length ; i++) {
			//计算第i行，左半边最接近半径的点
			int yLeftColumn = findDotEqualRadiusVersion2(i,0,2 * num,radius);
			for(int j = 0; j <= 2 * num; j++) {
				if( j == yLeftColumn) {
					System.out.print("*");
				}
				System.out.print(" ");
			}
			//计算第i行，右半边最接近半径的点
			int yRightColumn = findDotEqualRadiusVersion2(i,2 * num,width,radius);
			for(int j = 2 * num+1; j <= width; j++) {
				if( j == yRightColumn) {
					System.out.print("*");
				}
				System.out.print(" ");
			}
			System.out.println("");
		}	
	}
	//
	private static int findDotEqualRadiusVersion2(int i, int leftBorder, int rightBorder, int radius) {
		//int[] circleHeart = new int[]{radius,radius};//圆心坐标
		int[] circleHeart = new int[]{2 * radius,radius};//圆心坐标(因为横向坐标校短)
		double distance = 0.0d;
		int equalColumn = leftBorder;//记录最优点列坐标,默认最左边点
		int[] leftLocation = new int[]{i,leftBorder};
		//最左边点与圆心的距离
		distance = computeDistance(leftLocation, circleHeart); 
		double radiusError = Math.abs(distance - radius);//最左边点的起始误差
		for(int k = leftBorder; k <= rightBorder ; k++) {
			int[] temp = new int[]{i,k};//第i行，第k列坐标
			distance = computeDistance(temp, circleHeart);//与圆心距离
			double radiusErrorTemp = Math.abs(distance - radius);
			if(radiusErrorTemp < radiusError) {//若当前误差小于最优误差，则记录下当前列及误差值；
				equalColumn = k;
				radiusError = radiusErrorTemp;
			}
		}
		return equalColumn;
	}*/
