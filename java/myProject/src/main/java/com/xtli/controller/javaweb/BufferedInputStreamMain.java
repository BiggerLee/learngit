package com.xtli.controller.javaweb;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

//测试available()方法
/*public class Main {
  public static void main(String[] args) throws IOException {

    int i = 0;

    InputStream is = new FileInputStream("d://test.txt");
    FilterInputStream fis = new BufferedInputStream(is);

    while ((i = fis.read()) != -1) {
      char c = (char) i; // By: w w w . y i  I b a i. CO M 

      System.out.print("Read: " + c);

      int  j = fis.available();

      System.out.println("; Available bytes: " + j);
    }
  }
}*/

public class BufferedInputStreamMain {
	  public static void main(String[] args) throws Exception {

	    // create input streams
	    InputStream is = new FileInputStream("d://test.txt");//test.txt内容为'123456'
	    BufferedInputStream fis = new BufferedInputStream(is);
	    // 问题1、以下结果输出为ï » ¿ 1 2 3 4 5 6,其中为什么前三个字符为'ï » ¿',怎么来的？  	  
	    /*System.out.println((char) fis.read());
	    System.out.println((char) fis.read());
	    System.out.println((char) fis.read());
	    System.out.println((char)fis.read());
	    System.out.println((char)fis.read());
	    System.out.println((char)fis.read());
	    System.out.println((char)fis.read());
	    System.out.println((char)fis.read());*/
	    /*int b;
	    while((b = fis.read()) != -1) {
	    	System.out.println(b);
	    }*/
	    
	    
	    /* 
	     * 问题2、fill方法逻辑:
	     * 1 如果没有标记位置(mark<0)，则可以将缓冲数组中的数据都舍弃(throw away),将pos=0，以备继续读取底层流数据，覆盖原数据(全部覆盖还是只覆盖数组前面一部分，取决于还有多少流数据要被读取)；
    	   2 如果有标记位置(markpos>=0)，且pos<buffer.length时，表明buffer中有空间，则可以继续读取流数据
     	   3 如果有标记位置(markpos>=0),且pos>=buffer.length时，表明已经读到缓冲数组的末尾。
       		1) 如果markpos>0，也就是说此时标记位置markpos到pos之间的数据需要保存(以便reset),而缓冲数组中markpos之前的数据可以舍弃。将缓冲数组中需要保留的数据复制到此数组前面sz=pos-markpos的空间中，pos为sz,markpos=0为起始位置。然后可以从底层数据流中继续缓冲进buffer中大小为length-pos的数据。count为实际读取的字节大小+pos.
       		2) 如果markpos=0，且buffer的长度大于marklimit，则标记位置不再保留，pos=0，此时将缓冲数组的数据舍弃，继续读取底层流数据（即走规则1）,当调用reset方法时，此时会报异常(Resettin to invalid mark)
       		3）如果markpos=0，且buffer.length<=marklimit，则对buffer扩容，buffer的大小扩展为pos*2(当pos*2<marklimit时;如果pos*2>marklimit，则buffer的扩容后的大小为marklimit)，并将原buffer中保存的数据拷贝到新buffer中，继续读取底层流数据。
     		注：通过修改defaultBufferSize的大小，本地可以重现以上各种规则下的fill操作
	     */
	    
	    // mark invoked at this position
	    /*fis.mark(9);
	    System.out.println("mark() invoked");
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    fis.reset();
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());
	    System.out.println( fis.read());*/
	    
	    /*
	     * 问题3 read1方法
	     */
//	    byte[] b = new byte[16];
//	    int len;
//	    while((len = fis.read(b,2,13)) != -1) {
//	    	System.out.println(new String(b,0,len));
//	    }
	    /*
	     * 问题 4 skip方法
	     */
        //System.out.println(fis.read());
        System.out.println(fis.skip(20));
        System.out.println(fis.read());
	    
	  }
	}
