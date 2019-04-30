import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


class Mess{
	private float availability,nutrition,hygiene,mantainance,delay;
	int rank=0;
	public Mess(float availability, float nut, float hygiene, float delay) {
		this.availability=availability;
		this.nutrition=nut;
		this.hygiene=hygiene;
//		this.mantainance=mant;
		this.delay=delay;
	}
	public float getavailability() {
		return availability;
	}
	public float getNutrition() {
		return nutrition;
	}
	public float getHygiene() {
		return hygiene;
	}
//	public float getMantainance() {
//		return mantainance;
//	}
	public float getDelay() {
		return delay;
	}
	public  int getRank() {
		return rank;
	}
}

class Hostel{
	private float roomcond,study_faci,cleanliness,rec_faci;
	int rank=0;
	public Hostel(float cond, float studyfac, float cleanliness, float recreation) {
		this.roomcond=cond;
		this.study_faci=studyfac;
		this.cleanliness=cleanliness;
		this.rec_faci=recreation;
	}
	public float getRoomcond() {
		return roomcond;
	}
	public float getStudy_faci() {
		return study_faci;
	}
	public float getCleanliness() {
		return cleanliness;
	}
	public float getRec_faci() {
		return rec_faci;
	}
	public  int getRank() {
		return rank;
	}
}

class Library{
	private float availability, dig_faci, efficiency;
	float rank=0;
	public Library(float avl, float facilities, float eff) {
		this.availability=avl;
		this.dig_faci=facilities;
		this.efficiency=eff;
	}
	public float getAvailability() {
		return availability;
	}
	public float getDig_faci() {
		return dig_faci;
	}
	public float getEfficiency() {
		return efficiency;
	}
	public  float getRank() {
		return rank;
	}
}

class Academics{
	private float knowledge;
	private float domains;
	float rank=0;
	public float getKnowledge() {
		return knowledge;
	}
	public float getDomains() {
		return domains;
	}
	public float getEfficiency() {
		return efficiency;
	}
	float efficiency;
	public Academics(float knowledge, float dom, float eff) {
		this.knowledge=knowledge;
		this.domains=dom;
		this.efficiency=eff;
	}
	public  float getRank() {
		return rank;
	}
}

class Fees{
	private int fees;
	float rank=0;
	public Fees(int fees) {
		this.fees=fees;
	}
	public int getFees() {
		return fees;
	}
	public  float getRank() {
		return rank;
	}
}

class NAAC{
	private String c;
	int rank=0;
	public String getC() {
		return c;
	}
	public NAAC(String s) {
		this.c=s;
	}
	public String getCertificate() {
		return c;
	}
	public int getRank() {
		return rank;
	}
}

class College{
	String name;
	Mess mess;
	Hostel hostel;
	Library library;
	Academics academics;
	int finalrank;
	Fees fees;
	NAAC certificate;
	public String getName() {
		return name;
	}

	public Mess getMess() {
		return mess;
	}

	public void setMess(float a,float b, float c, float d){
		mess = new Mess(a,b,c,d);
	}


	public void setHostel(float a,float b, float c, float d){
		hostel = new Hostel(a,b,c,d);
	}


	public void setLibrary(float a,float b, float c){
		library = new Library(a,b,c);
	}

	public void setAcademics(float a,float b, float c){
		academics = new Academics(a,b,c);
	}	

	public void setFees(int a){
		fees = new Fees(a);
	}

	public void setNAAC(String s){
		certificate = new NAAC(s);
	}

	public Hostel getHostel() {
		return hostel;
	}

	public Library getLibrary() {
		return library;
	}

	public Fees getFees() {
		return fees;
	}

	public NAAC getCertificate() {
		return certificate;
	}

	public College(String n) {
		name=n;
	}
}

public class lab2 {
	static College[] A;
	static College[] aux;
	public static void main(String[] args) throws  IOException{
		// TODO Auto-generated method stub
		Reader1.init(System.in);
		int m=Reader1.nextInt();
		College[] clgarray=new College[m];
		for (int i=0;i<m;i++) {
			clgarray[i]=new College(Reader1.next());
			Reader1.next();
			clgarray[i].setMess(Reader1.nextFloat(),Reader1.nextFloat(),Reader1.nextFloat(),Reader1.nextFloat());

			Reader1.next();
			clgarray[i].setHostel(Reader1.nextFloat(),Reader1.nextFloat(),Reader1.nextFloat(),Reader1.nextFloat());

			Reader1.next();
			clgarray[i].setLibrary(Reader1.nextFloat(),Reader1.nextFloat(),Reader1.nextFloat());

			Reader1.next();
			clgarray[i].setAcademics(Reader1.nextFloat(),Reader1.nextFloat(),Reader1.nextFloat());

			Reader1.next();
			clgarray[i].setFees(Reader1.nextInt());

			Reader1.next();Reader1.next();
			clgarray[i].setNAAC(Reader1.next());
			// System.out.println("loop completed");
			}
		A=clgarray;
		messsort(clgarray,m);
		for (int i=0;i<m;i++) {
			A[i].mess.rank=i+1;
		}
		hostelsort(clgarray,m);
		for (int i=0;i<m;i++) {
			clgarray[i].hostel.rank=i+1;
		}
		librarysort(clgarray,m);
		for (int i=0;i<m;i++) {
			clgarray[i].library.rank=i+1;
		}
		Academicsort(clgarray,m);
		for (int i=0;i<m;i++) {
			clgarray[i].academics.rank=i+1;
		}
		collegesort(clgarray,m);
		System.out.println("List of colleges as per their ranking (starting from rank-1) is as following:");
		for (int i=0;i<m;i++) {
			clgarray[i].academics.rank=i+1;
			System.out.println(clgarray[i].name);
		}
	}
	public static void collegesort(College[] A,int n) { 

		aux = new College[n]; 
		collegemergesort(0, n - 1); 
	}

	private static void collegemergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			collegemergesort(low, middle);
			collegemergesort(middle + 1, high);
			// Combine both the sorted subarrays
			collegemerge(low, middle, high);
		}
	}
	
	private static void collegemerge(int low, int middle, int high) {
		// Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
		aux[i] = A[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
	// Copy the smallest
		while (i <= middle && j <= high) {
			float val1=(float)(0.25*aux[i].mess.getRank() + 0.2*aux[i].hostel.getRank() + 0.25*aux[i].library.getRank() + 0.3*aux[i].academics.getRank()); 
			float val2=(float)(0.25*aux[j].mess.getRank() + 0.2*aux[j].hostel.getRank() + 0.25*aux[j].library.getRank() + 0.3*aux[j].academics.getRank());
			if (val1==val2) {
				if (aux[i].fees.getFees()==aux[j].fees.getFees()) {
					if (aux[i].certificate.getCertificate().compareTo(aux[j].certificate.getCertificate())>0) {
							A[k]=aux[j];
							j++;
					}
					else {
						A[k]=aux[i];
						i++;
					}
				}
				else if (aux[i].fees.getFees()<aux[j].fees.getFees()) {
					A[k]=aux[i];
					i++;
				}
				else {
					A[k]=aux[j];
					j++;
				}
			}
			else if (val2>val1) {
			A[k] = aux[i];
			i++;
			} 
			
			else {
			A[k] = aux[j];
			j++;
			}
			k++;
			}
		while (i <= middle) {
			A[k] = aux[i];
			k++;
			i++;
		}
		while (j <= high) {
			A[k] = aux[j];
			k++;
			j++;
		}


	}

	public static void Academicsort(College[] A,int n) { 

		aux = new College[n]; 
		Academicmergesort(0, n - 1); 
	}

	private static void Academicmergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			Academicmergesort(low, middle);
			Academicmergesort(middle + 1, high);
			// Combine both the sorted subarrays
			Academicmerge(low, middle, high);
		}
	}
	
	private static void Academicmerge(int low, int middle, int high) {
		// Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
		aux[i] = A[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
	// Copy the smallest
		while (i <= middle && j <= high) {
			float val1=aux[i].academics.getDomains() + aux[i].academics.getKnowledge() + 2*aux[i].academics.getEfficiency();
			float val2=aux[j].academics.getDomains() + aux[j].academics.getKnowledge() + 2*aux[j].academics.getEfficiency();;
			if (val1>val2) {
			A[k] = aux[i];
			i++;
			} 
			
			else {
			A[k] = aux[j];
			j++;
			}
			k++;
			}
		while (i <= middle) {
			A[k] = aux[i];
			k++;
			i++;
		}
		while (j <= high) {
			A[k] = aux[j];
			k++;
			j++;
		}


	}

	
	
	public static void librarysort(College[] A,int n) { 

		aux = new College[n]; 
		librarymergesort(0, n - 1); 
	}

	private static void librarymergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			librarymergesort(low, middle);
			librarymergesort(middle + 1, high);
			// Combine both the sorted subarrays
			librarymerge(low, middle, high);
		}
	}
	
	private static void librarymerge(int low, int middle, int high) {
		// Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
		aux[i] = A[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
	// Copy the smallest
		while (i <= middle && j <= high) {
			float val1=aux[i].library.getAvailability() + aux[i].library.getDig_faci() + aux[i].library.getEfficiency();
			float val2=aux[j].library.getAvailability() + aux[j].library.getDig_faci() + aux[j].library.getEfficiency();
			if (val1>val2) {
			A[k] = aux[i];
			i++;
			} 
			
			else {
			A[k] = aux[j];
			j++;
			}
			k++;
			}
		while (i <= middle) {
			A[k] = aux[i];
			k++;
			i++;
		}
		while (j <= high) {
			A[k] = aux[j];
			k++;
			j++;
		}


	}

	
	
	
	public static void hostelsort(College[] A,int n) { 

		aux = new College[n]; 
		hostelmergesort(0, n - 1); 
	}

	private static void hostelmergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			hostelmergesort(low, middle);
			hostelmergesort(middle + 1, high);
			// Combine both the sorted subarrays
			hostelmerge(low, middle, high);
		}
	}
	
	private static void hostelmerge(int low, int middle, int high) {
		// Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
			aux[i] = A[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest
		while (i <= middle && j <= high) {
			if(aux[i].hostel.getRoomcond()==aux[j].hostel.getRoomcond()) {
				if  (aux[i].hostel.getStudy_faci()==aux[j].hostel.getStudy_faci()) {
					if (aux[i].hostel.getCleanliness()==aux[j].hostel.getCleanliness()) {
						if (aux[i].hostel.getRec_faci()>aux[j].hostel.getRec_faci()) {
							A[k]=aux[i];
							i++;
						}
						else {
							A[k]=aux[j];
							j++;
						}
					}
					else if(aux[i].hostel.getCleanliness()>aux[j].hostel.getCleanliness()){
						A[k]=aux[i];
						i++;
					}
					else {
						A[k]=aux[j];
						j++;
					}
				}
				else if (aux[i].hostel.getStudy_faci()>aux[j].hostel.getStudy_faci()) {
					A[k]=aux[i];
					i++;
				}
				else {
					A[k]=aux[j];
					j++;
				}
			}
			else if (aux[i].hostel.getRoomcond()>aux[j].hostel.getRoomcond()) {
				A[k] = aux[i];
				i++;
			} 

			else {
				A[k] = aux[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			A[k] = aux[i];
			k++;
			i++;
		}
		while (j <= high) {
			A[k] = aux[j];
			k++;
			j++;
		}


	}

	
	
	public static void messsort(College[] A,int n) { 

		aux = new College[n]; 
		messmergesort(0, n - 1); 
	}

	private static void messmergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			messmergesort(low, middle);
			messmergesort(middle + 1, high);
			// Combine both the sorted subarrays
			messmerge(low, middle, high);
		}
	}
	
	private static void messmerge(int low, int middle, int high) {
		// Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
			aux[i] = A[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest
		while (i <= middle && j <= high) {
			if(aux[i].mess.getavailability()==aux[j].mess.getavailability()) {
				if  (aux[i].mess.getNutrition()==aux[j].mess.getNutrition()) {
					if (aux[i].mess.getHygiene()==aux[j].mess.getHygiene()) {
						if (aux[i].mess.getDelay()<aux[j].mess.getDelay()) {
							A[k]=aux[i];
							i++;
						}
						else {
							A[k]=aux[j];
							j++;
						}
					}
					else if(aux[i].mess.getHygiene()>aux[j].mess.getHygiene()){
						A[k]=aux[i];
						i++;
					}
					else {
						A[k]=aux[j];
						j++;
					}
				}
				else if (aux[i].mess.getNutrition()>aux[j].mess.getNutrition()) {
					A[k]=aux[i];
					i++;
				}
				else {
					A[k]=aux[j];
					j++;
				}
			}
			else if (aux[i].mess.getavailability()>aux[j].mess.getavailability()) {
				A[k] = aux[i];
				i++;
			} 

			else {
				A[k] = aux[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			A[k] = aux[i];
			k++;
			i++;
		}
		while (j <= high) {
			A[k] = aux[j];
			k++;
			j++;
		}


	}


}
class Reader1 {
	static BufferedReader Reader1;
	static StringTokenizer tokenizer;
	/** call this method to initialize Reader1 for InputStream */
	static void init(InputStream input) {
		Reader1 = new BufferedReader(
				new InputStreamReader(input) );
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while ( ! tokenizer.hasMoreTokens() ) {
			//TODO add check for if necessary
			tokenizer = new StringTokenizer(
					Reader1.readLine() );
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt( next() );
	}

	static float nextFloat() throws IOException {
		return Float.parseFloat( next() );
	}
	static double nextDouble() throws IOException {
		return Double.parseDouble( next() );
	}
} 