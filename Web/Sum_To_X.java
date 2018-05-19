import java.util.*;
/**
 * �ж������������Ƿ����������֮��ΪX
 * @author ����
 *
 */
public class Sum_To_X {
	//�����������ڽ���ʼ���鰴��������
	public void QUICKSORT(int S[],int p,int r) {
		if(p<r) {
			int q=PARTITION(S,p,r);
			QUICKSORT(S,p,q-1);
			QUICKSORT(S,q+1,r);
		}
	}
	public int PARTITION(int S[],int p,int r) {
		int x=S[r];
		int m;
		int i=p-1;
		for(int j=p;j<=r-1;j++) {
			if(S[j]<=x) {
				i++;
				m=S[i];
				S[i]=S[j];
				S[j]=m;
			}
		}
		m=S[i+1];
		S[i+1]=S[r];
		S[r]=m;
		return i+1;
	}
	
	//�ж��������Ƿ����������֮�͵���X
	public void Sum_to_x(int S[],int low,int high,int x) {
		int i=low,j=high;  
	    while (i<j){  
	        if(x==(S[i]+S[j])){  
	         System.out.println("���ҵ���Ϊ"+x+"������Ԫ�أ��ֱ�Ϊ"+S[i]+","+S[j]); 
	         return;
	        }
	        else if(x<(S[i]+S[j])) --j;  
	        else  ++i;   
	    }  
	    System.out.println("�޷��ҵ���Ϊ"+x+"������Ԫ�أ�");
	}
	
	public static void main(String args[]) {
		int S[]= {3,23,4,12,6,18,26,1,8};
		int x=13;
		System.out.println("S����Ϊ�� "+Arrays.toString(S));		
		Sum_To_X m=new Sum_To_X();
		m.QUICKSORT(S, 0, S.length-1);
		System.out.println("S���������Ϊ�� "+Arrays.toString(S));
		System.out.println("XΪ��"+x);
		m.Sum_to_x(S, 0, S.length-1, x);
	}
}

